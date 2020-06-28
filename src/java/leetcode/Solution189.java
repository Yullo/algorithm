package leetcode;

/**
 * Created by HAOYUXING on 2020/6/24.
 */
public class Solution189 {

    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     *
     * 示例 1:
     *
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     * 示例 2:
     *
     * 输入: [-1,-100,3,99] 和 k = 2
     * 输出: [3,99,-1,-100]
     * 解释:
     * 向右旋转 1 步: [99,-1,-100,3]
     * 向右旋转 2 步: [3,99,-1,-100]
     * 说明:
     *
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 要求使用空间复杂度为 O(1) 的 原地 算法。
     *
     * 链接：https://leetcode-cn.com/problems/rotate-array
     */

    public void rotate(int[] nums, int k) {
        // 每次移动一个元素
        for (int i = 0; i < k; i++) {
            int t = nums[nums.length - 1];
            for (int j = nums.length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = t;
        }
    }

    public void rotateV2(int[] nums, int k) {
        // 计数器，每有一个元素移动成功就加1
        int count = 0;
        // 最坏的情况是移动k轮
        for (int j = 0; j < k; j++) {
            // 所有元素都移动了，结束
            if (count >= nums.length) {
                break;
            }
            int t = nums[j];
            int i = (j + k) % nums.length;
            while (i != j) {
                int m = nums[i];
                nums[i] = t;
                t = m;
                i = (i + k) % nums.length;
                count++;
            }
            nums[j] = t;
            count++;
        }
    }

    public void rotateV3(int[] nums, int k) {
        k = k % nums.length;
        // 三次反转
        int l = nums.length - 1 - k;
        reverse(nums, 0, l);
        reverse(nums, l + 1, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int begin, int end) {
        while (begin < end) {
            int t = nums[begin];
            nums[begin] = nums[end];
            nums[end] = t;
            begin++;
            end--;
        }
    }
}
