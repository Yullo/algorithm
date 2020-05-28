package leetcode;

/**
 * Created by HAOYUXING on 2020/5/28.
 */
public class Solution66 {

    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * 示例 1:
     *
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 示例 2:
     *
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     *
     * 链接：https://leetcode-cn.com/problems/plus-one
     */

    public int[] plusOne(int[] digits) {
        int jin = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int m = digits[i] + jin;
            if (m < 10) {
                digits[i] = m;
                return digits;
            } else {
                digits[i] = m % 10;
                jin = m / 10;
            }
        }
        // 到这里说明全是9
        int[] ints = new int[digits.length + 1];
        ints[0] = 1;
        return ints;
    }
}
