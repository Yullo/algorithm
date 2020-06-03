package leetcode;

/**
 * Created by HAOYUXING on 2020/6/2.
 */
public class Solution84 {

    /**
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     *
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     *
     *  
     *
     *
     *
     * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
     *
     *  
     *
     *
     *
     * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
     *
     *  
     *
     * 示例:
     *
     * 输入: [2,1,5,6,2,3]
     * 输出: 10
     *
     * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
     */


    /**
     * 解析：
     * 与 42 接雨水类似， 关键是找到边界
     */
    public int largestRectangleArea(int[] heights) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int l = i;
            int r = i;
            // 找到左边第一个比它小的，就是左边界
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (heights[j] < heights[i]) {
                    l = j;
                    break;
                }
            }
            // 如果找到最左边都没有找到，说明左边都满足，则把边界设成 -1
            if (j == -1) {
                l = -1;
            }

            // 找到右边第一个比它小的就是右边界
            for (j = i + 1; j < heights.length; j++) {
                if (heights[j] < heights[i]) {
                    r = j;
                    break;
                }
            }
            // 如果右边都满足
            if (j == heights.length) {
                r = heights.length;
            }
            res = Math.max(res, heights[i] * (r - l - 1));

        }
        return Math.max(res, 0);
    }


    // 暴力求解 O(n ^ 2)  会超时
    public int largestRectangleAreaV2(int[] heights) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            for (int j = heights.length - 1; j >= i; j--) {
                int hight = getMin(heights, i, j);
                res = Math.max(res, hight * (j - i + 1));
            }

        }
        return Math.max(res, 0);
    }

    private int getMin(int[] heights, int l, int r) {
        int min = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            min = Math.min(heights[i], min);
        }
        return min;
    }

    public static void main(String[] args) {
        Solution84 solution84 = new Solution84();
        System.out.println(solution84.largestRectangleArea(new int[]{4, 2, 0, 3, 2, 4, 3, 4}));
    }
}
