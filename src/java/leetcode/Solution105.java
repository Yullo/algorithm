package leetcode;

/**
 * Created by HAOYUXING on 2020/6/8.
 */
public class Solution105 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    /**
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     *
     * 注意:
     * 你可以假设树中没有重复的元素。
     *
     * 例如，给出
     *
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
     */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int root = preorder[0];
        TreeNode node = new TreeNode(root);
        int idx = searchIdx(root, inorder);

        int[] leftPre = new int[idx];
        int[] leftIn = new int[idx];

        for (int i = 0; i < idx; i++) {
            leftPre[i] = preorder[i + 1];
            leftIn[i] = inorder[i];
        }

        node.left = buildTree(leftPre, leftIn);

        int[] rightPre = new int[preorder.length - idx - 1];
        int[] rigtIn = new int[inorder.length - idx - 1];

        for (int i = 0; i < preorder.length - idx - 1; i++) {
            rightPre[i] = preorder[idx + 1 + i];
            rigtIn[i] = inorder[idx + 1 + i];
        }

        node.right = buildTree(rightPre, rigtIn);
        return node;
    }

    // 返回的值既是索引，又是下一层左子树的长度
    private int searchIdx(int num, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                return i;
            }
        }
        return -1;
    }


    // 上面的解法重新创建了数组，空间复杂度较高， 使用索引优化
    public TreeNode buildTreeV2(int[] preorder, int[] inorder) {
        return createNode(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    // 左闭右开
    private TreeNode createNode(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft >= preRight) {
            return null;
        }
        int num = preorder[preLeft];
        int idx = searchIdx(num, inorder);
        int length = idx - inLeft;

        TreeNode node = new TreeNode(num);
        node.left = createNode(preorder, preLeft + 1, preLeft + 1 + length, inorder, inLeft, idx);
        node.right = createNode(preorder, preLeft + 1 + length, preRight, inorder, idx + 1, inRight);

        return node;
    }

    /**
     * 解析：
     * 看到数组作为参数，一定要想到先利用索引。 使用索引递归时，位置都是相对位置，所以要用步长计算绝对位置。
     */

}
