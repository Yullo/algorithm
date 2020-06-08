package leetcode;

/**
 * Created by HAOYUXING on 2020/6/8.
 */
public class Solution108 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    /**
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     *
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     *
     * 示例:
     *
     * 给定有序数组: [-10,-3,0,5,9],
     *
     * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     *
     * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
     */

    public TreeNode sortedArrayToBST(int[] nums) {
        return createNode(nums, 0, nums.length);
    }

    // 左闭右开
    private TreeNode createNode(int[] nums, int left, int right) {
        if (left >= right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = createNode(nums, left, mid);
        node.right = createNode(nums, mid + 1, right);
        return node;
    }
}
