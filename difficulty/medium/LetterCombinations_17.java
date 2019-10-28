package difficulty.medium;
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
// 示例:
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
// 说明:
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
// Related Topics 字符串 回溯算法

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations_17 {
    public static void main(String[] args) {
        LetterCombinations_17 test = new LetterCombinations_17();
        String digits = "24";
        System.out.println(test.letterCombinations(digits));
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.equals("")) {
            return res;
        }
        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        dfs(digits, "", 0, res, map);
        return res;
    }

    /**
     * 回溯法
     *
     * @param digits
     * @param str
     * @param index  第几个位置
     * @param res
     * @param map
     */
    public void dfs(String digits, String str, int index, List<String> res, Map<String, String> map) {
        if (index == digits.length()) {
            res.add(str);
            return;
        }

        String number = String.valueOf(digits.charAt(index));
        for (int i = 0; i < map.get(number).length(); i++) {    //第index+1个位置可以放的元素进行循环
            dfs(digits, str + map.get(number).charAt(i), index + 1, res, map);
        }

        if (str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
    }
}
