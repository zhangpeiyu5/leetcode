package difficulty.medium;

/**
 * 扫雷游戏
 * <p>
 * https://leetcode-cn.com/problems/minesweeper/description/
 */
public class MineSweeper_529 {
    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = {-1, 0, 1, 1, -1, -1, 0, 1};

    public static void main(String[] args) {
        MineSweeper_529 test = new MineSweeper_529();
        int[] click = new int[2];
        click[0] = 3;
        click[1] = 0;
        char[][] board = new char[4][5];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = 'E';
            }
        }
        board[1][2] = 'M';
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                System.out.print(board[i][j]);
//                System.out.print(" ");
//            }
//            System.out.println();
//        }

        char[][] res = test.updateBoard(board, click);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

    }

    public char[][] updateBoard(char[][] board, int[] click) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        dfs(board, click[0], click[1], visited);
        return board;
    }

    public void dfs(char[][] board, int x, int y, boolean[][] visited) {
        //terminator
        if (board[x][y] != 'E') {
            if (board[x][y] == 'M') {
                board[x][y] = 'X';
            }
            return;
        }

        //current level process
        char count = calcAdjacentMnums(board, x, y);
        if (count == '0') {
            board[x][y] = 'B';
        } else {
            board[x][y] = count;
        }
        visited[x][y] = true;

        //drill down
        for (int i = 0; i < dx.length; i++) {
            //if...
            if (board[x][y] == 'B' && x + dx[i] >= 0 && x + dx[i] < board.length && y + dy[i] >= 0 && y + dy[i] < board[0].length &&
                    !visited[x + dx[i]][y + dy[i]]) {
                dfs(board, x + dx[i], y + dy[i], visited);
            }
        }
    }

    public char calcAdjacentMnums(char[][] board, int x, int y) {
        char count = '0';
        for (int i = 0; i < dx.length; i++) {
            if (x + dx[i] >= 0 && x + dx[i] < board.length && y + dy[i] >= 0 && y + dy[i] < board[0].length) {
                if (board[x + dx[i]][y + dy[i]] == 'M') {
                    count++;
                }
            }
        }
        return count;
    }
}
