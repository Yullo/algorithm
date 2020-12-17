package leetcode;

import java.util.Stack;

/**
 * Created by HAOYUXING on 2020/12/17.
 */
public class Solution114 {

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
     * 给定一个二叉树，原地将它展开为一个单链表。
     *
     *  
     *
     * 例如，给定二叉树
     *
     *     1
     *    / \
     *   2   5
     *  / \   \
     * 3   4   6
     * 将其展开为：
     *
     * 1
     *  \
     *   2
     *    \
     *     3
     *      \
     *       4
     *        \
     *         5
     *          \
     *           6
     *
     * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
     */

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            // 右子树要最后处理，所以要先加到栈中
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (!stack.isEmpty()) {
                cur.right = stack.peek();
            }
            cur.left = null;
        }
    }
}
