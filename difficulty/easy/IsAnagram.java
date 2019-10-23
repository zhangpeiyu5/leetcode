package easy;


import java.util.Arrays;
import java.util.HashMap;

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 示例 1:
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
//
//
// 示例 2:
//
// 输入: s = "rat", t = "car"
//输出: false
//
// 说明:
//你可以假设字符串只包含小写字母。
//
// 进阶:
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// Related Topics 排序 哈希表
public class IsAnagram {
    public static void main(String[] args) {
        IsAnagram test = new IsAnagram();
        String s = "rart";
        String t = "artr";
        System.out.println(test.isAnagram3(s, t));
    }

    /**
     * 方法一：直接对字符串排序
     * <p>
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        byte[] sbytes = s.getBytes();
        byte[] tBytes = t.getBytes();
        Arrays.sort(sbytes);
        Arrays.sort(tBytes);
        return Arrays.equals(sbytes, tBytes);
    }

    /**
     * 方法二：哈希表
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if (null != s && null != t && s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                return false;
            } else {
                if (map.get(t.charAt(i)) > 1) {
                    map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                } else {
                    map.remove(t.charAt(i));
                }
            }
        }
        if (map.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 方法三：用数组记录字符出现的个数。这种方法有限制（本题限制为只包含小写字母）
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram3(String s, String t) {
        if (null != s && null != t && s.length() != t.length()) {
            return false;
        }
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
            nums[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
