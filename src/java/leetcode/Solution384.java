package leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by HAOYUXING on 2020/7/21.
 */
public class Solution384 {

    /**
     * 打乱一个没有重复元素的数组。
     *
     *  
     *
     * 示例:
     *
     * // 以数字集合 1, 2 和 3 初始化数组。
     * int[] nums = {1,2,3};
     * Solution solution = new Solution(nums);
     *
     * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
     * solution.shuffle();
     *
     * // 重设数组到它的初始状态[1,2,3]。
     * solution.reset();
     *
     * // 随机返回数组[1,2,3]打乱后的结果。
     * solution.shuffle();
     *
     * 链接：https://leetcode-cn.com/problems/shuffle-an-array
     */


    // 洗牌算法 ， 洗牌算法的正确性: 产生的结果必须有 n! 种可能. 一个数组n的全排列共有 n! 种
    class Solution {

        private int[] nums;
        private Random random = new Random();

        public Solution(int[] nums) {
            this.nums = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] shuffle = Arrays.copyOf(nums, nums.length);
            for (int i = shuffle.length - 1; i >= 0; i++) {
                int nextInt = random.nextInt(i + 1);
                int t = shuffle[nextInt];
                shuffle[nextInt] = shuffle[i];
                shuffle[i] = t;
            }
            return shuffle;
        }
    }

    /**
     * 洗牌算法
     * https://github.com/labuladong/fucking-algorithm/blob/master/%E7%AE%97%E6%B3%95%E6%80%9D%E7%BB%B4%E7%B3%BB%E5%88%97/%E6%B4%97%E7%89%8C%E7%AE%97%E6%B3%95.md
     */
}
