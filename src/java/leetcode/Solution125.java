package leetcode;

/**
 * Created by HAOYUXING on 2020/6/10.
 */
public class Solution125 {

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     *
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     *
     * 示例 1:
     *
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * 示例 2:
     *
     * 输入: "race a car"
     * 输出: false
     *
     * 链接：https://leetcode-cn.com/problems/valid-palindrome
     */

    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            char lc = s.charAt(l);
            if (!isNumOrLetter(lc)) {
                l++;
                continue;
            }
            char rc = s.charAt(r);
            if (!isNumOrLetter(rc)) {
                r--;
                continue;
            }
            // 判断大小写时， 两个都必须不能是数字
            if (lc == rc || (lc - '9' > 0 && rc - '9' > 0 && Math.abs(lc - rc) == 'a' - 'A')) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean isNumOrLetter(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static void main(String[] args) {
        Solution125 solution125 = new Solution125();
        System.out.println(solution125.isPalindrome("0P"));
    }
}
