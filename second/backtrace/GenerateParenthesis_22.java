package second.backtrace;

import java.util.ArrayList;
import java.util.List;

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
public class GenerateParenthesis_22 {
    public static void main(String[] args) {
        GenerateParenthesis_22 test = new GenerateParenthesis_22();
        int n = 3;
        System.out.println(test.generateParenthesis(n));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n - 1, n, "(", res);
        return res;
    }

    public void dfs(int leftNum, int rightNum, String s, List<String> res) {
        //terminator
        if (leftNum == 0 && rightNum == 0) {
            res.add(s);
            return;
        }

        if (leftNum > 0) {
            dfs(leftNum - 1, rightNum, s + "(", res);
        }
        //左括号数大于右括号数
        if (rightNum > leftNum) {
            dfs(leftNum, rightNum - 1, s + ")", res);
        }
    }
}
