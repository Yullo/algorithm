package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by HAOYUXING on 2020/6/4.
 */
public class Solution94 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    /**
     * 给定一个二叉树，返回它的中序 遍历。
     *
     * 示例:
     *
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [1,3,2]
     *
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     *
     * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
     */

    // 迭代法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            // 将左子树挨个压入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 处理根节点
            TreeNode node = stack.pop();
            list.add(node.val);
            // 递归右子树
            root = node.right;
        }
        return list;
    }


    // 递归法
    public List<Integer> inorderTraversalV2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverl(root, list);
        return list;
    }

    private void traverl(TreeNode root, List<Integer> list) {
        if (root != null) {
            traverl(root.left, list);
            list.add(root.val);
            traverl(root.right, list);
        }
    }

    public static void main(String[] args) {
        Solution94 solution94 = new Solution94();
        TreeNode node3 = solution94.new TreeNode(3);
        TreeNode node2 = solution94.new TreeNode(2);
        node2.left = node3;

        TreeNode node1 = solution94.new TreeNode(1);
        node1.right = node2;

        solution94.inorderTraversal(node1);
    }
}
