package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by HAOYUXING on 2020/7/16.
 */
public class Solution295 {

    /**
     * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
     *
     * 例如，
     *
     * [2,3,4] 的中位数是 3
     *
     * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
     *
     * 设计一个支持以下两种操作的数据结构：
     *
     * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
     * double findMedian() - 返回目前所有元素的中位数。
     * 示例：
     *
     * addNum(1)
     * addNum(2)
     * findMedian() -> 1.5
     * addNum(3)
     * findMedian() -> 2
     *
     * 进阶:
     *
     * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
     * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
     *
     * 链接：https://leetcode-cn.com/problems/find-median-from-data-stream
     */


    /**
     * 构造一个大顶堆，存储数据小的那一半数据
     * 构造一个小顶堆，存储数据大的那一半数据
     * 这样两个堆顶的元素就是中间的那两数字
     *
     * 保证两个堆的数据个数差不能超过1， 则，偶数时，为两个数字平均值，奇数时，多的那个元素即为结果
     */
    class MedianFinder {
        PriorityQueue<Integer> min;
        PriorityQueue<Integer> max;

        /** initialize your data structure here. */
        public MedianFinder() {
            min = new PriorityQueue<>();
            max = new PriorityQueue<>(Comparator.reverseOrder());
        }

        public void addNum(int num) {
            // 如果初始态 或者 数字属于前半段
            if (min.peek() == null || min.peek() >= num) {
                // 加到前半段
                max.offer(num);
                // 加入之后如果多了，就从前面拿出一个放到后面
                if (max.size() - min.size() > 1) {
                    min.offer(max.poll());
                }
            } else {
                // 数字属于后半段，则加到后半段
                min.offer(num);
                // 加入之后如果多了，就拿出一个放到前面
                if (min.size() - max.size() > 1) {
                    max.offer(min.poll());
                }
            }
        }

        public double findMedian() {
            int n = min.size();
            int m = max.size();
            if ((n + m) % 2 == 0) {
                return (min.peek() + max.peek()) * 0.5;
            } else {
                return n > m ? min.peek() : max.peek();
            }
        }
    }
}
