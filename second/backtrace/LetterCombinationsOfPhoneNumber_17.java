package second.backtrace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class LetterCombinationsOfPhoneNumber_17 {

    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber_17 test = new LetterCombinationsOfPhoneNumber_17();
        String digits = "";
        System.out.println(test.letterCombinations(digits));
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || "".equals(digits)) {
            return res;
        }
        Map<String, String> numberMap = new HashMap<>();
        numberMap.put("2", "abc");
        numberMap.put("3", "def");
        numberMap.put("4", "ghi");
        numberMap.put("5", "jkl");
        numberMap.put("6", "mno");
        numberMap.put("7", "pqrs");
        numberMap.put("8", "tuv");
        numberMap.put("9", "wxyz");

        dfs(digits, 0, numberMap, "", res);

        return res;
    }

    public void dfs(String digits, int index, Map<String, String> map, String str, List<String> res) {
        //terminator
        if (index == digits.length()) {
            res.add(str);
            return;
        }

        //process current level
        int num = digits.charAt(index) - '0';
        String characterStr = map.get(String.valueOf(num));
        for (int i = 0; i < characterStr.length(); i++) {
            //next level
            dfs(digits, index + 1, map, str + characterStr.charAt(i), res);
        }
    }
}
