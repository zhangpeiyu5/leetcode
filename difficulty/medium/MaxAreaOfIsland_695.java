package difficulty.medium;

/**
 *  岛屿的最大面积
 *
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 */
public class MaxAreaOfIsland_695 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int count = 0;

    public static void main(String[] args) {
        int[][] grid = new int[1][2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = 0;
            }
        }
//        grid[0][0] = 1;
        grid[0][1] = 1;
//        grid[1][0] = 1;
//        grid[1][1] = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count = 0;
                    dfs(grid, i, j);
                    max = Math.max(count, max);
                }
            }
        }
        return max;
    }

    private static void dfs(int[][] grid, int i, int j) {
        //递归终止条件
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] != 1) {
            return;
        }
        //处理本层
        grid[i][j] = 0;
        count++;

        //下探到下一层
        for (int k = 0; k < dx.length; k++) {
            dfs(grid, i + dx[k], j + dy[k]);
        }
        //清理本层
    }
}
