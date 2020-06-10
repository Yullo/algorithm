package leetcode;

/**
 * Created by HAOYUXING on 2020/6/9.
 */
public class Solution124 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }


    /**
     *给定一个非空二叉树，返回其最大路径和。
     *
     * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
     *
     * 示例 1:
     *
     * 输入: [1,2,3]
     *
     *        1
     *       / \
     *      2   3
     *
     * 输出: 6
     * 示例 2:
     *
     * 输入: [-10,9,20,null,null,15,7]
     *
     *    -10
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 输出: 42
     *
     * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
     */

    public int maxPathSum(TreeNode root) {
        int res = maxPathSum(root, 0);
        return Math.max(local, res);
    }

    private int local = Integer.MIN_VALUE;

    private int maxPathSum(TreeNode node, int parent) {
        if (node == null) {
            return 0;
        }
        // 左右子树, 不考虑负数
        int left = Math.max(maxPathSum(node.left, parent), 0);
        int right = Math.max(maxPathSum(node.right, parent), 0);
        // 1 和 2
        parent = Math.max(left, right) + node.val + parent;
        // 3
        local = Math.max(left + right + node.val, local);

        // 递归返回的是1和2的最大值
        return parent;
    }


    /**
     * 解析：
     *
     * 要理解路径的意思，路径不一定经过根节点，意思是，可以不从父节点下来。
     *
     * 所以路径总共有这么几种情况：
     * 1. 父节点 + 本节点值 + 左子树
     * 2. 父节点 + 本节点值 + 右子树
     * 3. 本节点值 + 左子树 + 右子树
     * 4. 本节点值 + 左子树
     * 5. 本节点值 + 右子树
     * 6. 本节点值
     *
     * 3 一定大于等于 4，5，6,只需要考虑 1，2，3 即可
     * 同时负数一定会使和减小，所以子树是负数不需要考虑
     *
     * 需要注意的是，3的子树只能是1，2, 不能是3. 因为3没有父节点。同理 1，2 的子树也只能是 1，2
     * 所以3的值是独立的，不需要参加递归
     * 所以递归函数只需要返回子树的最大值即可，同时使用全局变量存储3的值，子树更新时，同步更新3的值
     * 最后的结果就是 12 最大值和3的最大值比较。
     */
}
