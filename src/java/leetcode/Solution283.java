package leetcode;

/**
 * Created by HAOYUXING on 2020/7/10.
 */
public class Solution283 {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     *
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     *
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     *
     * 链接：https://leetcode-cn.com/problems/move-zeroes
     */

    public void moveZeroes(int[] nums) {
        // 找到第一个0的位置
        int zero = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero = i;
                break;
            }
        }
        // 没找到，说明没有0
        if (zero < 0) {
            return;
        }
        for (int i = zero + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[zero++] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
