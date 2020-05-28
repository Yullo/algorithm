package leetcode;

/**
 * Created by HAOYUXING on 2020/5/27.
 */
public class Solution55 {

    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     *
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 判断你是否能够到达最后一个位置。
     *
     * 示例 1:
     *
     * 输入: [2,3,1,1,4]
     * 输出: true
     * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
     * 示例 2:
     *
     * 输入: [3,2,1,0,4]
     * 输出: false
     * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
     *
     * 链接：https://leetcode-cn.com/problems/jump-game
     */

    public boolean canJump(int[] nums) {
        // 从后往前检查
        for (int i = nums.length - 2; i >= 0; i--) {
            if (!check(nums, i, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean check(int nums[], int i, int step) {
        if (i < 0) {
            return false;
        }
        // 这个跳不到，则递归检查前面的
   /*     if(nums[i] < step){
            return check(nums, i - 1, step + 1);
        }else{
            // 只要有一个能跳到，就返回true
            return true;
        }*/

        return nums[i] >= step || check(nums, i - 1, step + 1);
    }


    // 复杂度O(n)
    public boolean canJumpV2(int[] nums) {
        // 当前节点到达最后最少需要的步数
        int step = 1;
        // 从后往前检查
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < step) {
                step++;
            } else {
                step = 1;
            }
        }
        return step == 1;
    }


    public static void main(String[] args) {
        Solution55 solution55 = new Solution55();
        System.out.println(solution55.canJumpV2(new int[]{1, 0, 2, 0, 4}));
    }
}
