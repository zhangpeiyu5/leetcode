package second.backtrace;

import java.util.ArrayList;
import java.util.List;

//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//
//
// 上图为 8 皇后问题的一种解法。
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
// 示例:
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
public class NQueens_51 {
    public static void main(String[] args) {
        NQueens_51 test = new NQueens_51();
        int n = 4;
        System.out.println(test.solveNQueens(n));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(".");
        }

        boolean[] cols = new boolean[n];
        boolean[] pies = new boolean[2 * n - 1];
        boolean[] nas = new boolean[2 * n - 1];

        dfs(cols, pies, nas, 0, n, sb, new ArrayList<>(), res);

        return res;
    }

    public void dfs(boolean[] cols, boolean[] pies, boolean[] nas, int row, int n, StringBuilder sb, List<String> list, List<List<String>> res) {
        //terminator
        if (row == n) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int col = 0; col < n; col++) {
            //剪枝
            if (cols[col] || pies[col + row] || nas[col - row + n - 1]) {
                continue;
            }

            cols[col] = true;
            pies[col + row] = true;
            nas[col - row + n - 1] = true;
            sb.replace(col, col + 1, "Q");
            list.add(sb.toString());
            sb.replace(col, col + 1, ".");

            //next level
            dfs(cols, pies, nas, row + 1, n, sb, list, res);

            cols[col] = false;
            pies[col + row] = false;
            nas[col - row + n - 1] = false;
            list.remove(row);
        }
    }
}
