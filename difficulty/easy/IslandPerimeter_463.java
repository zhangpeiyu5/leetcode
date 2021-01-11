package difficulty.easy;

/**
 * 岛屿的周长
 */
public class IslandPerimeter_463 {
    private static int perimeter;

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        int[][] grid = {{1}};
        System.out.println(islandPerimeter(grid));
    }

    public static int islandPerimeter(int[][] grid) {
        perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    return perimeter;
                }
            }
        }
        return 0;
    }

    private static void dfs(int[][] grid, int i, int j) {
        //递归终止条件
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] != 1) {
            return;
        }

        //处理本层
        grid[i][j] = -1;
        //上（在边缘或上面是0，周长加1）
        if (i == 0 || grid[i - 1][j] == 0) {
            perimeter++;
        }
        //下（在边缘或下面是0，周长加1）
        if (i == grid.length - 1 || grid[i + 1][j] == 0) {
            perimeter++;
        }
        //左（在边缘或左边是0，周长加1）
        if (j == 0 || grid[i][j - 1] == 0) {
            perimeter++;
        }
        //右（在边缘或右边是0，周长加1）
        if (j == grid[0].length - 1 || grid[i][j + 1] == 0) {
            perimeter++;
        }


        //下探到下一层
        for (int k = 0; k < dx.length; k++) {
            dfs(grid, i + dx[k], j + dy[k]);
        }
    }
}
