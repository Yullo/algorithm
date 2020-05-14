package leetcode;

/**
 * Created by HAOYUXING on 2020/5/12.
 */
public class Solution8 {
    /**
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     *
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
     *
     * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
     * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
     * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
     *
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
     *
     * 提示：
     *
     * 本题中的空白字符只包括空格字符 ' ' 。
     * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2 ^ 31,  2 ^ 31 − 1]。如果数值超过这个范围，请返回  INT_MAX (2 ^ 31 − 1) 或 INT_MIN (−2 ^ 31) 。
     *  
     *
     * 示例 1:
     *
     * 输入: "42"
     * 输出: 42
     * 示例 2:
     *
     * 输入: "   -42"
     * 输出: -42
     * 解释: 第一个非空白字符为 '-', 它是一个负号。
     *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
     * 示例 3:
     *
     * 输入: "4193 with words"
     * 输出: 4193
     * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
     * 示例 4:
     *
     * 输入: "words and 987"
     * 输出: 0
     * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     *      因此无法执行有效的转换。
     * 示例 5:
     *
     * 输入: "-91283472332"
     * 输出: -2147483648
     * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     *      因此返回 INT_MIN (−2 ^ 31) 。
     *
     * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
     */
    public int myAtoi(String str) {
        // 去除开头空白字符
        str = trimBegin(str);
        // 如果为空或者是开始字符非有效字符直接返回
        if (str.length() == 0 || !validate(str.charAt(0))) {
            return 0;
        }
        char c = str.charAt(0);
        // 如果只有一个字符，并且是正负号直接返回
        if (str.length() == 1 && !validateNum(c)) {
            return 0;
        }
        // 如果连续的正负号，直接返回
        if (validateSign(c) && !validateNum(str.charAt(1))) {
            return 0;
        }
        // 截取出有效的数字部分
        for (int i = 1; i < str.length(); i++) {
            if (!validateNum(str.charAt(i))) {
                str = str.substring(0, i);
            }
        }
        int i = validateSign(str.charAt(0)) ? 1 : 0;
        long res = 0;

        for (; i < str.length(); i++) {
            res = res * 10 + Integer.valueOf(str.charAt(i) + "");

            if (res > Integer.MAX_VALUE) {
                res = c == '-' ? Integer.MAX_VALUE + 1 : Integer.MAX_VALUE;
                break;
            }
        }

        return (int) (res = c == '-' ? res * -1 : res);
    }

    private boolean validate(char c) {
        return validateNum(c) || validateSign(c);
    }

    private boolean validateNum(char c) {
        return (c >= '0' && c <= '9');
    }

    private boolean validateSign(char c) {
        return c == '-' || c == '+';
    }

    private String trimBegin(String str) {
        while (str.indexOf(" ") == 0) {
            str = str.substring(1);
        }
        return str;
    }

    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        System.out.println(solution8.myAtoi("-42"));
    }

    /**
     *     public int myAtoi(String str) {
     *         int len = str.length();
     *         if (len == 0) return 0;
     *         int i = 0;//字符串索引
     *         int sign = 1;//正数结果还是负数结果
     *         int total = 0;//最后的结果
     *
     *         //跳过空字符
     *         while (i < len && str.charAt(i) == ' ') i++;
     *         //判断是正数还是负数
     *         if (i < len && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
     *             sign = str.charAt(i++) == '-' ? -1 : 1;
     *         }
     *         //开始统计后面的数字
     *         while (i < len) {
     *             int val = str.charAt(i) - '0';
     *             if(val < 0 || val > 9) break;
     *             //如果Integer的最大值 / 10 < total，拿下次计算，肯定是溢出了，
     *             //如果Integer的最大值 / 10 = total，且最大值求余 < val，那么肯定也是溢出
     *             if (Integer.MAX_VALUE / 10 < total || (Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < val)) {
     *                 return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
     *             }
     *             total = total * 10 + val;
     *             i++;
     *         }
     *         return total * sign;
     *     }
     *
     * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi/solution/zhi-xing-yong-shi-1-ms-zai-suo-you-java-ti-jiao-55/
     */

}
