package second.medium;

import java.util.LinkedList;
import java.util.Queue;

//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
//
// 示例 1:
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
//
//
// 示例 2:
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
//
// Related Topics 深度优先搜索 广度优先搜索 并查集
public class NumIslands_200 {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        NumIslands_200 test = new NumIslands_200();
        char[][] grid = new char[4][5];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = '0';
            }
        }

        grid[0][0] = '1';
        grid[0][1] = '1';
        grid[0][2] = '1';
        grid[0][3] = '1';
        grid[1][0] = '1';
        grid[1][1] = '1';
        grid[1][3] = '1';
        grid[2][0] = '1';
        grid[2][1] = '1';

//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                System.out.print(grid[i][j]);
//                System.out.print(" ");
//            }
//            System.out.println();
//        }
        System.out.println(test.numIslands2(grid));
    }

    /**
     * 方法一：DFS
     *
     * @param grid
     * @return
     */
    public int numIslands1(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        for (int k = 0; k < dx.length; k++) {
            if ((i + dx[k]) >= 0 && (i + dx[k]) < grid.length && (j + dy[k]) >= 0 && (j + dy[k]) < grid[i].length) {
                dfs(grid, i + dx[k], j + dy[k]);
            }
        }
    }

    /**
     * BFS
     * @param grid
     * @return
     */
    public int numIslands2(char[][] grid) {
        int count = 0;
        Queue<Coordinates> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    Coordinates coordinates = new Coordinates(i, j);
                    queue.add(coordinates);
                    grid[i][j] = '0';
                    count++;
                }
                while (!queue.isEmpty()) {
                    Coordinates cur = queue.poll();
                    int row = cur.getRow();
                    int column = cur.getColumn();
                    for (int k = 0; k < dx.length; k++) {
                        if ((row + dx[k]) >= 0 && (row + dx[k]) < grid.length && (column + dy[k]) >= 0 && (column + dy[k]) < grid[0].length && grid[row + dx[k]][column + dy[k]] == '1') {
                            Coordinates coordinates = new Coordinates(row + dx[k], column + dy[k]);
                            queue.add(coordinates);
                            grid[row + dx[k]][column + dy[k]] = '0';
                        }
                    }
                }
            }
        }
        return count;
    }


    private class Coordinates {
        int row;
        int column;

        public Coordinates(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getColumn() {
            return column;
        }

        public void setColumn(int column) {
            this.column = column;
        }
    }


}
