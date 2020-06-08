package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by HAOYUXING on 2020/6/8.
 */
public class Solution116 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
     *
     * struct Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
     * }
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     *
     * 初始状态下，所有 next 指针都被设置为 NULL。
     *
     *
     *
     * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
     *  
     *
     * 提示：
     *
     * 你只能使用常量级额外空间。
     * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
     *
     * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
     */

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node last = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node != null) {
                    node.next = last;
                    last = node;
                    queue.offer(node.right);
                    queue.offer(node.left);
                }
            }
        }
        return root;
    }
}
