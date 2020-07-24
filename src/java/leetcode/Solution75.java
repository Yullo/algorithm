package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by HAOYUXING on 2020/5/29.
 */
public class Solution75 {

    /**
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     *
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     *
     * 注意:
     * 不能使用代码库中的排序函数来解决这道题。
     *
     * 示例:
     *
     * 输入: [2,0,2,1,1,0]
     * 输出: [0,0,1,1,2,2]
     * 进阶：
     *
     * 一个直观的解决方案是使用计数排序的两趟扫描算法。
     * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
     * 你能想出一个仅使用常数空间的一趟扫描算法吗？
     *
     * 链接：https://leetcode-cn.com/problems/sort-colors
     *
     * TAG：三指针（荷兰国旗）
     */

    // 三指针
    public void sortColors(int[] nums) {
        // 整理好的0的位置
        int l = 0;
        // 整理好的2的位置
        int r = nums.length - 1;
        // 待检查的元素
        for (int i = 0; i <= r; i++) {
            if (nums[i] == 0) {
                swap(nums, i, l);
                l++;
            }
            if (nums[i] == 2) {
                swap(nums, i, r);
                r--;
                // 从后面换过来的数是未知的，需要重新检查
                i--;
            }
        }
    }

    private void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }


    // 使用计数排序的两趟扫描算法
    public void sortColorsV2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer value = map.getOrDefault(num, 0);
            map.put(num, value + 1);
        }
        int i = 0;
        for (int k = 0; k < 3; k++) {
            Integer num = map.get(k);
            if (num == null) {
                continue;
            }
            for (int j = num; j > 0; j--) {
                nums[i++] = k;
            }
        }
    }

    public static void main(String[] args) {
        Solution75 solution75 = new Solution75();
        int[] ints = {0, 0, 1, 1, 2, 1, 0};
        solution75.sortColors(ints);
        System.out.println(Arrays.toString(ints));
    }
}
