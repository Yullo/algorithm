import java.util.Stack;

/**
 * Created by painsolace on 2017/4/25.
 * 要求： 反转一颗二叉树
 * 输入：                输出：
 *          5                  5
 *        /   \              /   \
 *       3     7            7     3
 *      / \   / \          / \   / \
 *     2   4 6   8        8   6 4   2
 */
public class TreeReverse {
    class Node{
        private Node left;
        private Node right;
        private int value;
        public Node(Node left, Node right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }

    public void reverse(Node node){
        if(node == null)
            return;
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        reverse(node.left);
        reverse(node.right);
        //return node;

    }

    public void norecursive(Node node){
        if(node == null)
            return;
        Stack<Node> stack = new Stack<Node>();
        stack.push(node);
        while(!stack.empty()){
            node = stack.pop();
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
            if( node.left != null)
                stack.push(node.left);
            if( node.right != null)
                stack.push(node.right);
        }
    }

    public void printTree(Node node){
        if(node == null) return;
        System.out.print(node.value);
        printTree(node.left);
        printTree(node.right);
    }
}
