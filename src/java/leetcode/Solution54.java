package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HAOYUXING on 2020/5/22.
 */
public class Solution54 {

    /**
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     *
     * 示例 1:
     *
     * 输入:
     * [
     *  [ 1, 2, 3 ],
     *  [ 4, 5, 6 ],
     *  [ 7, 8, 9 ]
     * ]
     * 输出: [1,2,3,6,9,8,7,4,5]
     * 示例 2:
     *
     * 输入:
     * [
     *   [1, 2, 3, 4],
     *   [5, 6, 7, 8],
     *   [9,10,11,12]
     * ]
     * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
     *
     * 链接：https://leetcode-cn.com/problems/spiral-matrix
     */

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }

        // 上下左右四条边
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        // 循环过程中时刻检测边的位置，如果越界，说明所有元素都遍历完毕
        while (up <= down && left <= right) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
            if (++up > down) break;
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            if (--right < left) break;
            for (int i = right; i >= left; i--) {
                list.add(matrix[down][i]);
            }
            if (--down < up) break;
            for (int i = down; i >= up; i--) {
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }
}
