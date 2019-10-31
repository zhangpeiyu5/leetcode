package medium;

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
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        NumIslands_200 test = new NumIslands_200();
        char[][] grid = new char[1][1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = 0;
            }
        }
        grid[0][0] = '1';
//        grid[0][1] = '1';
//        grid[1][0] = '1';
//        grid[1][1] = '1';
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid.length; j++) {
//                System.out.println(new Integer(grid[i][j]));
//            }
//        }
        System.out.println(test.numIslands1(grid));

    }

    /**
     * 方法一：DFS
     * floodfill 碰到1时，岛屿数加一，并且用dfs把与它相连的1全部变为0，以此类推。
     *
     * @param grid
     * @return
     */
    public int numIslands1(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    ++count;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
        //terminator
        if (grid[i][j] == '0') {
            return;
        }
        //process
        grid[i][j] = '0';

        //drill down
        for (int k = 0; k < dx.length; k++) {
            //if...
            if ((i + dx[k]) >= 0 && (i + dx[k]) < grid.length && (j + dy[k]) >= 0 && (j + dy[k]) < grid[0].length) {
                dfs(grid, i + dx[k], j + dy[k]);
            }
        }
    }

    /**
     * 方法二：BFS
     * @param grid
     * @return
     */
    public int numIslands2(char[][] grid) {
        int count = 0;

        return count;
    }


}
