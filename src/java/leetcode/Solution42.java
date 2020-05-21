package leetcode;

/**
 * Created by HAOYUXING on 2020/5/21.
 */
public class Solution42 {

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     *
     *
     * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     *
     * 示例:
     *      |
     *      |               |
     *      |               |
     *      |       |       |   |
     *      |       |   |   |   |
     *      |   |   |   |   |   |
     *      |___|___|___|___|___|___|_____
     *
     *
     * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出: 6
     *
     * 链接：https://leetcode-cn.com/problems/trapping-rain-water
     */

    // 暴力遍历每个柱子能存的水
    public int trap(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            // 最小也要和这个柱子一样高吧
            int maxLeft = height[i];
            int maxRight = maxLeft;
            // 找到左边最高的
            for (int j = i - 1; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            // 找到右边最高的
            for (int j = i + 1; j < height.length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            res += Math.min(maxLeft, maxRight) - height[i];
        }

        return res;
    }

    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        System.out.println(solution42.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
