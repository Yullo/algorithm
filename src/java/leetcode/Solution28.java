package leetcode;

/**
 * Created by HAOYUXING on 2020/5/19.
 */
public class Solution28 {

    /**
     * 实现 strStr() 函数。
     *
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     *
     * 示例 1:
     *
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 示例 2:
     *
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     * 说明:
     *
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     *
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     *
     * 链接：https://leetcode-cn.com/problems/implement-strstr
     */

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        // 从每个字符开始判断
        for (int i = 0; i < haystack.length(); i++) {
            int h = i, n = 0;
            while (n < needle.length() && h < haystack.length()) {
                if (haystack.charAt(h) == needle.charAt(n)) {
                    h++;
                    n++;
                } else {
                    break;
                }
            }
            if (n == needle.length()) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        System.out.println(solution28.strStr("hello", "m"));
    }
}

