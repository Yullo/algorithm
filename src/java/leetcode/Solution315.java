package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HAOYUXING on 2020/7/17.
 */
public class Solution315 {

    /**
     * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
     *
     *  
     *
     * 示例：
     *
     * 输入：[5,2,6,1]
     * 输出：[2,1,1,0]
     * 解释：
     * 5 的右侧有 2 个更小的元素 (2 和 1)
     * 2 的右侧仅有 1 个更小的元素 (1)
     * 6 的右侧有 1 个更小的元素 (1)
     * 1 的右侧有 0 个更小的元素
     *
     * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
     */

    // 使用一个额外的空间，存储已经遍历过的数字， 并使其有序
    // 那么遍历下个数的时候，二分查找有序的结构，找到插入位置，通过下标即可知道小于它的个数， 之后把这个数放入合适位置
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }

        List<Integer> temp = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int left = 0;
            int right = temp.size();
            // 找到第一个大与等于它的位置
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (temp.get(mid) < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            // 小于它的个数，即为位置索引
            list.add(0, left);
            // 也是插入位置
            temp.add(left, nums[i]);
        }
        return list;
    }

    // 暴力计数，超时
    public List<Integer> countSmallerV2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }

        list.add(0);

        for (int i = nums.length - 2; i >= 0; i--) {
            int m = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    m++;
                }
            }
            list.add(0, m);
        }
        return list;
    }

    public static void main(String[] args) {
        Solution315 solution315 = new Solution315();
        System.out.println(solution315.countSmaller(new int[]{5, 5, 5, 5}));
    }

}
