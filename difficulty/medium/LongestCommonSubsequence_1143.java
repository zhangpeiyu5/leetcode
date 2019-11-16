package difficulty.medium;

//给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
//例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
//
// 若这两个字符串没有公共子序列，则返回 0。
//
//
//
// 示例 1:
//
// 输入：text1 = "abcde", text2 = "ace"
//输出：3
//解释：最长公共子序列是 "ace"，它的长度为 3。
//
//
// 示例 2:
//
// 输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc"，它的长度为 3。
//
//
// 示例 3:
//
// 输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0。
public class LongestCommonSubsequence_1143 {
    public static void main(String[] args) {
        LongestCommonSubsequence_1143 test = new LongestCommonSubsequence_1143();
        String text1 = "abcde";
        String text2 = "ace";

        System.out.println(test.longestCommonSubsequence(text1, text2));

    }

    /**
     * 动态规划
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int m = s1.length;
        int n = s2.length;
        int[][] dp = new int[m + 1][n + 1];


        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

}
