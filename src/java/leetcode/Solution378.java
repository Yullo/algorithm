package leetcode;

/**
 * Created by HAOYUXING on 2020/7/21.
 */
public class Solution378 {

    /**
     * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
     * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
     *
     *  
     *
     * 示例：
     *
     * matrix = [
     *    [ 1,  5,  9],
     *    [10, 11, 13],
     *    [12, 13, 15]
     * ],
     * k = 8,
     *
     * 返回 13。
     *  
     *
     * 提示：
     * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n ^ 2 。
     *
     * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
     *
     */

    // 第一种方法： 转化成一维数组
    // 第二种方法： 在二维数组中二分查找
    public int kthSmallest(int[][] matrix, int k) {
        // 左上角最小
        int left = matrix[0][0];
        // 右下角最大
        int right = matrix[matrix.length - 1][matrix[0].length - 1];
        // 这里使用等于号是为了, 再走一轮，移动指针，使 left 指向正确的数
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            // 小于等于中间的个数
            int c = count(matrix, mid);
            // 少，说明中间的数小了，往右移
            if (c < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // 统计小于等于mid的个数
    private int count(int[][] matrix, int mid) {
        int res = 0;
        // 第一行
        int i = 0;
        // 最后一列
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            // 大于等于最右边的数
            if (mid >= matrix[i][j]) {
                // 统计个数
                res += j + 1;
                // 统计下一行
                i++;
            } else {
                // 向左移动，寻找最右的数
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution378 solution378 = new Solution378();
        System.out.println(solution378.kthSmallest(new int[][]{{1, 2}, {1, 3}}, 3));
    }
}
