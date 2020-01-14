/**
 * Created by HAOYUXING on 2020/1/14.
 */
public class Node {
    public int val;

    public Node next;

    public Node(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
            "val=" + val +
            '}';
    }

    public static Node create(int... args) {
        if (args.length == 0) {
            return null;
        }
        Node dummy = new Node(0);
        Node current = dummy;
        for (int arg : args) {
            current.next = new Node(arg);
            current = current.next;
        }
        return dummy.next;
    }

    private String print(){
        return this.toString() + " --> " + next.toString();
    }

}
