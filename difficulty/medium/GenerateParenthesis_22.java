package difficulty.medium;
//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
//
// 例如，给出 n = 3，生成结果为：
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
//
// Related Topics 字符串 回溯算法

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis_22 {
    public static void main(String[] args) {
        GenerateParenthesis_22 test = new GenerateParenthesis_22();
        int n = 3;
        System.out.println(test.generateParenthesis(n));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(0, 0, n, "", list);
        return list;
    }

    /**
     * 方法一：递归法
     *
     * @param left
     * @param right
     * @param n
     * @param str
     * @param list
     */
    public void helper(int left, int right, int n, String str, List<String> list) {
        if (left == n && right == n) {
            list.add(str);
            return;
        }

        if (left < n) {
            helper(left + 1, right, n, str + "(", list);
        }
        if (right < left) {
            helper(left, right + 1, n, str + ")", list);
        }

    }
}
