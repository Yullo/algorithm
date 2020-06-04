package leetcode;

import java.util.Stack;

/**
 * Created by HAOYUXING on 2020/6/4.
 */
public class Solution98 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     *
     * 假设一个二叉搜索树具有如下特征：
     *
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * 示例 1:
     *
     * 输入:
     *     2
     *    / \
     *   1   3
     * 输出: true
     * 示例 2:
     *
     * 输入:
     *     5
     *    / \
     *   1   4
     *      / \
     *     3   6
     * 输出: false
     * 解释: 输入为: [5,1,4,null,null,3,6]。
     *      根节点的值为 5 ，但是其右子节点值为 4 。
     *
     * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
     */

    // 左子树的全部节点小于根节点，右子树的全部节点大于根节点
    // 所以中序遍历的结果是单调递增的
    public boolean isValidBST(TreeNode root) {
        Integer pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if (pre != null && node.val <= pre) {
                return false;
            }
            pre = node.val;
            root = node.right;
        }
        return true;
    }
}
