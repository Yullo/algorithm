package leetcode;

/**
 * Created by HAOYUXING on 2020/7/20.
 */
public class Solution329 {

    /**
     *给定一个整数矩阵，找出最长递增路径的长度。
     *
     * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
     *
     * 示例 1:
     *
     * 输入: nums =
     * [
     *   [9,9,4],
     *   [6,6,8],
     *   [2,1,1]
     * ]
     * 输出: 4
     * 解释: 最长递增路径为 [1, 2, 6, 9]。
     *
     * 示例 2:
     *
     * 输入: nums =
     * [
     *   [3,4,5],
     *   [3,2,6],
     *   [2,2,1]
     * ]
     * 输出: 4
     * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
     *
     * 链接：https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix
     */

    public int longestIncreasingPath(int[][] matrix) {
        int res = 0;
        if (matrix.length == 0) {
            return res;
        }
        // 记录从某个点开始搜索时它的结果
        int[][] mem = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res = Math.max(res, dfs(matrix, i, j, Integer.MIN_VALUE, mem));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int i, int j, int last, int[][] mem) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == Integer.MIN_VALUE || matrix[i][j] <= last) {
            return 0;
        }
        if (mem[i][j] > 0) {
            return mem[i][j];
        }

        int t = matrix[i][j];
        matrix[i][j] = Integer.MIN_VALUE;

        // 选择
        int a = dfs(matrix, i + 1, j, t, mem);
        int b = dfs(matrix, i - 1, j, t, mem);
        int c = dfs(matrix, i, j + 1, t, mem);
        int d = dfs(matrix, i, j - 1, t, mem);
        // 还原
        matrix[i][j] = t;

        a = Math.max(a, b);
        c = Math.max(c, d);
        int res = Math.max(a, c) + 1;
        // 备忘录
        mem[i][j] = res;
        return res;
    }
}
