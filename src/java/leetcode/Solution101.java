package leetcode;

import java.util.Stack;

/**
 * Created by HAOYUXING on 2020/6/5.
 */
public class Solution101 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     *
     *  
     *
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     *  
     *
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     *
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     *  
     *
     * 进阶：
     *
     * 你可以运用递归和迭代两种方法解决这个问题吗？
     *
     * 链接：https://leetcode-cn.com/problems/symmetric-tree
     */


    // 递归法，判断 左子树的左节点和右子树的右节点 并且 左子树的右节点和右子树的左节点 是否相同
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }


    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    // 迭代法
    public boolean isSymmetricV2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(root.left);

        Stack<TreeNode> stack2 = new Stack<>();
        stack2.push(root.right);

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }
            stack1.push(node1.left);
            stack1.push(node1.right);

            stack2.push(node2.right);
            stack2.push(node2.left);
        }
        return true;
    }


    /**
     * 解析：
     * 任何一个递归都可以改成迭代
     * 树的深度优先遍历都可以用栈作为缓存，递归需要判断几条路线，就需要几个栈
     */


}
