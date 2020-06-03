package leetcode;

/**
 * Created by HAOYUXING on 2020/6/3.
 */
public class Solution88 {

    /**
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     *
     *  
     *
     * 说明:
     *
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     *  
     *
     * 示例:
     *
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     *
     * 输出: [1,2,2,3,5,6]
     *
     * 链接：https://leetcode-cn.com/problems/merge-sorted-array
     */

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 已知两个数组有序， 从后往前扫描即可
        for (int i = m + n - 1; i >= 0; i--) {
            if (n == 0) {
                m--;
                continue;
            }
            if (m == 0 || nums1[m - 1] < nums2[n - 1]) {
                nums1[i] = nums2[n - 1];
                n--;
            } else {
                nums1[i] = nums1[m - 1];
                m--;
            }
        }
    }

    public void mergeV2(int[] nums1, int m, int[] nums2, int n) {
        int l1 = 0;
        int l2 = 0;
        // 每次拿 nums2 的一个元素插入nums1 , 其实是变相的搬迁数据
        while (l2 < n) {
            while (l1 < m) {
                if (nums1[l1] > nums2[l2]) {
                    int t = nums1[l1];
                    nums1[l1] = nums2[l2];
                    nums2[l2] = t;
                }
                l1++;
            }
            nums1[l1] = nums2[l2];
            l2++;
            l1 = l2;
            m++;
        }
    }
}
