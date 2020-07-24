package leetcode;

/**
 * Created by HAOYUXING on 2020/5/11.
 */
public class Solution5 {
    /**
     * 5. 最长回文子串
     *
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 示例 1：
     *
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     *
     * 输入: "cbbd"
     * 输出: "bb"
     *
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     */

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = search(s, i, i);
            String s2 = search(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    //同时处理回文串长度为奇数和偶数的情况
    private String search(String s, int left, int right) {
        // 从中间向两边扩散
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.longestPalindrome("baacaayxcaa"));
    }
}
