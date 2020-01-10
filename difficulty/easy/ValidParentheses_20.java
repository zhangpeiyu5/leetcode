package difficulty.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
// 注意空字符串可被认为是有效字符串。
//
// 示例 1:
//
// 输入: "()"
//输出: true
//
//
// 示例 2:
//
// 输入: "()[]{}"
//输出: true
//
//
// 示例 3:
//
// 输入: "(]"
//输出: false
//
public class ValidParentheses_20 {
    public static void main(String[] args) {
        ValidParentheses_20 test = new ValidParentheses_20();
        String s = "()[]{}";
        System.out.println(test.isValid(s));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put('[', ']');
        mapping.put('{', '}');
        mapping.put('(', ')');
        for (int i = 0; i < s.length(); i++) {
            //如果是(、[、{，加入栈
            if (mapping.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                //如果是)、]、}且栈为空，说明先出现了右括号，不是有效的。
                if (stack.isEmpty()) {
                    return false;
                }

                //栈顶的元素和右括号不匹配，不是有效的。
                Character pop = stack.pop();
                if (mapping.get(pop) != s.charAt(i)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
