package medium;
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串

import java.util.*;

public class GroupAnagrams_49 {
    public static void main(String[] args) {
        GroupAnagrams_49 test = new GroupAnagrams_49();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = test.groupAnagrams2(strs);
        System.out.println(list);
    }

    /**
     * 方法一：数组排序分类
     * <p>
     * 时间复杂度：O(nk*logk) n为字符串个数，k为strs中字符串的最大长度
     * 空间复杂度：O(nk)
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            byte[] bytes = strs[i].getBytes();
            Arrays.sort(bytes);
            String key = new String(bytes);
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key, list);
            } else {
                map.get(key).add(strs[i]);
            }
        }
        return new ArrayList<>(map.values());
    }


    /**
     * 方法二：统计字符数分类
     * <p>
     * 时间复杂度：O(nk)
     * 空间复杂度：O(nk)
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        Map<String, List<String>> map = new HashMap<>();
        int[] nums = new int[26];
        for (int i = 0; i < strs.length; i++) {
            Arrays.fill(nums, 0);
            for (int j = 0; j < strs[i].length(); j++) {
                nums[strs[i].charAt(j) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < nums.length; k++) {
                sb.append(nums[k]).append("#");
            }
            String key = sb.toString();
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key, list);
            } else {
                map.get(key).add(strs[i]);
            }
        }
        return new ArrayList<>(map.values());
    }
}
