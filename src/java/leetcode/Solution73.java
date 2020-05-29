package leetcode;

/**
 * Created by HAOYUXING on 2020/5/28.
 */
public class Solution73 {
    /**
     * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
     *
     * 示例 1:
     *
     * 输入:
     * [
     *   [1,1,1],
     *   [1,0,1],
     *   [1,1,1]
     * ]
     * 输出:
     * [
     *   [1,0,1],
     *   [0,0,0],
     *   [1,0,1]
     * ]
     * 示例 2:
     *
     * 输入:
     * [
     *   [0,1,2,0],
     *   [3,4,5,2],
     *   [1,3,1,5]
     * ]
     * 输出:
     * [
     *   [0,0,0,0],
     *   [0,4,5,0],
     *   [0,3,1,0]
     * ]
     * formal
     * 进阶:
     *
     * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
     * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
     * 你能想出一个常数空间的解决方案吗？
     *
     * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
     */

    public void setZeroes(int[][] matrix) {

        // 首行是否要变0
        boolean row = false;
        // 首列是否要变0
        boolean col = false;
        // 用首行首列标记是否需要变0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) row = true;
                    if (j == 0) col = true;
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 扫描首行首列之外的数据，根据标记变0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 首行变0
        for (int i = 0; i < matrix[0].length && row; i++) {
            matrix[0][i] = 0;
        }
        // 首列变0
        for (int i = 0; i < matrix.length && col; i++) {
            matrix[i][0] = 0;
        }
    }

    /**
     * 解析：
     *
     * 如果O(mn)空间：直接新开一个m*n的数组，扫描原数组，置0操作在新数组中执行，这样就不必担心置0后续遍历的结果。
     *
     * 如果O(m+n)空间。那么可以分别开两个m，n长度的数组，分别记录这一行/这一列中有没有0出现，有则置0，最后根据这两个数组哪些元素即可判断哪些行以及哪些列需要置0。
     *
     * 如果是常数空间，直接使用原数组的第一行和第一列元素记录当前行或者当前列中除本身以外是否存在0，如果存在0，则将首元素置0，如用a[2][0]记录第3行中除了a[2][0]以外的元素中是否存在0，如果后者中出现0了，那么我们将a[2][0]置0。
     *
     * 但是这样有一个问题：我如何处理第一行或者第一列中本身就有0存在？因此我们又需要额外两个变量判断第一行以及第一列本身是否存在0。
     */
}
