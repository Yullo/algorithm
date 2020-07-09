package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by HAOYUXING on 2020/7/8.
 */
public class Solution239 {

    /**
     * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     *
     * 返回滑动窗口中的最大值。
     *
     *  
     *
     * 进阶：
     *
     * 你能在线性时间复杂度内解决此题吗？
     *
     *  
     *
     * 示例:
     *
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     *
     *   滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 10^5
     * -10^4 <= nums[i] <= 10^4
     * 1 <= k <= nums.length
     *
     * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
     */


    public int[] maxSlidingWindow(int[] nums, int k) {
        int res[] = new int[nums.length - k + 1];
        int idx = 0;
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);

            //删除左边过期元素
            if (queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }

            //滑倒位置后，存放结果
            if (i >= k - 1) {
                res[idx++] = nums[queue.peekFirst()];
            }
        }

        return res;
    }

    /**
     *  构造一个滑动窗口，使窗口内元素从左到右降序排列
     *  新的元素进来时，需要检查窗口内元素，如果小于新元素，需要踢出窗口
     *  如果左边的元素已经滑出窗口，需要踢出窗口
     *  如果窗口内元素满了，最左边的就是结果
     */
}
