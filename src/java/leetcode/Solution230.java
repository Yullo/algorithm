package leetcode;

/**
 * Created by HAOYUXING on 2020/7/7.
 */
public class Solution230 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    /**
     * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
     *
     * 说明：
     * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
     *
     * 示例 1:
     *
     * 输入: root = [3,1,4,null,2], k = 1
     *    3
     *   / \
     *  1   4
     *   \
     *    2
     * 输出: 1
     * 示例 2:
     *
     * 输入: root = [5,3,6,2,4,null,null,1], k = 3
     *        5
     *       / \
     *      3   6
     *     / \
     *    2   4
     *   /
     *  1
     * 输出: 3
     * 进阶：
     * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
     *
     * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
     */


    // 二叉搜索树是有序的，直接二分查找
    public int kthSmallest(TreeNode root, int k) {
        int leftNum = findNum(root.left);
        if (k == leftNum + 1) {
            return root.val;
        }
        // 在右子树上
        if (k > leftNum + 1) {
            return kthSmallest(root.right, k - (leftNum + 1));
        } else {
            // 在左子树上
            return kthSmallest(root.left, k);
        }

    }
    // 查找子树的节点个数
    private int findNum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + findNum(node.left) + findNum(node.right);
    }


}
