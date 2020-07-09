package leetcode;

/**
 * Created by HAOYUXING on 2020/7/9.
 */
public class Solution240 {

    /**
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
     *
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     *
     * 示例:
     *
     * 现有矩阵 matrix 如下：
     *
     * [
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * ]
     * 给定 target = 5，返回 true。
     *
     * 给定 target = 20，返回 false。
     *
     * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
     */

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int n = 0;
        int m = matrix[0].length - 1;
        // 从右上角开始扫描
        while (n < matrix.length && m >= 0) {
            int num = matrix[n][m];
            if (num == target) {
                return true;
            }
            // 若大于目标值，说明这一列都大
            if (num > target) {
                m--;
            }
            // 若小于目标值，说明这一行都小
            else {
                n++;
            }
        }
        return false;
    }
}
