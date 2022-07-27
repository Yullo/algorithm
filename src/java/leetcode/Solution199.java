package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by HAOYUXING on 2022/7/28.
 */
public class Solution199 {


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
     * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     *
     *  
     *
     * 示例 1:
     *
     *
     *
     * 输入: [1,2,3,null,5,null,4]
     * 输出: [1,3,4]
     * 示例 2:
     *
     * 输入: [1,null,3]
     * 输出: [1,3]
     * 示例 3:
     *
     * 输入: []
     * 输出: []
     *  
     *
     * 提示:
     *
     * 二叉树的节点个数的范围是 [0,100]
     * -100 <= Node.val <= 100 
     *
     * 链接：https://leetcode.cn/problems/binary-tree-right-side-view
     */


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size ; i++) {
                TreeNode node = queue.poll();
                if (i == size-1) {
                    res.add(node.val);
                }
                // 必须判空，否则会影响末尾节点的判断
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
}
