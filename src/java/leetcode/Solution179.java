package leetcode;

/**
 * Created by HAOYUXING on 2020/6/24.
 */
public class Solution179 {

    /**
     * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
     *
     * 示例 1:
     *
     * 输入: [10,2]
     * 输出: 210
     * 示例 2:
     *
     * 输入: [3,30,34,5,9]
     * 输出: 9534330
     * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     *
     * 链接：https://leetcode-cn.com/problems/largest-number
     */

    public String largestNumber(int[] nums) {
        // 自定义排序，大的值在前面
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // 转成字符串
                String num1 = nums[i] + "";
                String num2 = nums[j] + "";

                // 拼接后再比较
                if ((num2 + num1).compareTo(num1 + num2) > 0) {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
        }

        // 最大位是0 结果是0
        if (nums[0] == 0) {
            return "0";
        }

        // 拼接结果
        String res = "";
        for (int num : nums) {
            res += num;
        }

        return res;
    }
}
