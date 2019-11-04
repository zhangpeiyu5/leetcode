package second.medium;

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

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = '0';
            }
        }
        System.out.println(test.numIslands1(grid));
    }

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
            if (i + dx[k] > 0 && i + dx[k] < grid.length && j + dy[k] > 0 && j + dy[k] < grid[i].length) {
                dfs(grid, i + dx[k], j + dy[k]);
            }
        }
    }


}
