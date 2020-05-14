package leetcode;

/**
 * Created by HAOYUXING on 2020/5/14.
 */
public class Solution14 {
    /**
     * 14. 最长公共前缀
     *
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     *
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     *
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     *
     * 链接：https://leetcode-cn.com/problems/longest-common-prefix
     */

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String base = strs[0];
        for (int i = 0; i < base.length(); i++) {
            char c = base.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return base.substring(0, i);
                }
            }
        }
        return base;
    }
}
