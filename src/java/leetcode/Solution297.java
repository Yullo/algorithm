package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by HAOYUXING on 2020/7/16.
 */
public class Solution297 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    /**
     * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
     *
     * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
     *
     * 示例: 
     *
     * 你可以将以下二叉树：
     *
     *     1
     *    / \
     *   2   3
     *      / \
     *     4   5
     *
     * 序列化为 "[1,2,3,null,null,4,5]"
     *
     * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
     *
     * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
     *
     * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
     */


    // 由于可能有重复的值，所以无法通过前序和中序反推一颗树
    // 使用层次遍历,空节点使用 # 号代替
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return null;
            }
            String res = "";
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node == null) {
                        res += "#" + ",";
                    } else {
                        res += node.val + ",";
                        queue.offer(node.left);
                        queue.offer(node.right);
                    }
                }
            }
            return res;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null) {
                return null;
            }
            data = data.substring(0, data.length() - 1);
            String[] split = data.split(",");

            // 使用队列来存储根节点
            Queue<TreeNode> queue = new LinkedList<>();
            int idx = 0;

            TreeNode root = new TreeNode(Integer.valueOf(split[idx++]));
            queue.offer(root);

            while (!queue.isEmpty()) {
                // 每取一个根节点， 取后面对应的两个值
                TreeNode node = queue.poll();
                String left = split[idx++];
                if (left.equals("#")) {
                    node.left = null;
                } else {
                    node.left = new TreeNode(Integer.valueOf(left));
                    queue.offer(node.left);
                }
                String right = split[idx++];
                if (right.equals("#")) {
                    node.right = null;
                } else {
                    node.right = new TreeNode(Integer.valueOf(right));
                    queue.offer(node.right);
                }
            }
            return root;
        }
    }

}
