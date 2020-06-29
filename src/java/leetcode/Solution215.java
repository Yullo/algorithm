package leetcode;

import java.util.PriorityQueue;

/**
 * Created by HAOYUXING on 2020/6/29.
 */
public class Solution215 {

    /**
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     * 示例 1:
     *
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * 示例 2:
     *
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     * 说明:
     *
     * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     *
     * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
     */


    // 后续需要自己实现一个堆排序
    public int findKthLargest(int[] nums, int k) {
        // 构建数量为K的小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) {
                queue.offer(nums[i]);
            }
            // 若数字比最小值大，替换最小值，插入堆中
            else if (queue.peek() < nums[i]) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }
}
