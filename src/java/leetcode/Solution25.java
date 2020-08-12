package leetcode;

/**
 * Created by HAOYUXING on 2020/8/11.
 */
public class Solution25 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    /**
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     *
     * k 是一个正整数，它的值小于或等于链表的长度。
     *
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     *  
     *
     * 示例：
     *
     * 给你这个链表：1->2->3->4->5
     *
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     *
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     *
     *  
     *
     * 说明：
     *
     * 你的算法只能使用常数的额外空间。
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     *
     * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        // 先走k步，找到翻转截至的点
        for (int i = 0; i < k; i++) {
            // 不够k个，返回原来的头节点
            if (cur == null) {
                return head;
            }
            cur = cur.next;
        }
        // 要反转的链表就是 head 到 cur, 不包括 cur
        // 翻转过后，返回的是新的头节点
        ListNode newHead = normalReserve(head, cur);
        // 原来的头节点变成了尾节点，后面要接的是下一轮返回的头节点
        head.next = reverseKGroup(cur, k);
        return newHead;
    }

    // 正常的三指针翻转 ，翻转过后头尾互换，返回新链表的头节点
    private ListNode normalReserve(ListNode node, ListNode end) {
        ListNode pre = null;
        while (node != end) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }


    // 遍历法
    public ListNode reverseKGroupV2(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        // 前驱指针
        ListNode pre = new ListNode(-1);
        pre.next = head;
        // 用来保存结果
        ListNode dummy = pre;
        int i = 1;
        while (head != null) {
            if (i % k != 0) {
                head = head.next;
            } else {
                ListNode t = head.next;
                pre = reverse(pre, t);
                head = t;
            }
            i++;
        }
        return dummy.next;
    }

    // 使用了四个指针，不好理解，画图会清晰一点
    private ListNode reverse(ListNode pre, ListNode head) {
        ListNode lp = pre.next;
        ListNode cur = lp.next;
        while (cur != head) {
            lp.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = lp.next;
        }
        return lp;
    }


    public static void main(String[] args) {
        Solution25 solution25 = new Solution25();
        ListNode node5 = solution25.new ListNode(5);
        ListNode node4 = solution25.new ListNode(4);
        ListNode node3 = solution25.new ListNode(3);
        ListNode node2 = solution25.new ListNode(2);
        ListNode node1 = solution25.new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        solution25.reverseKGroup(node1, 2);
    }
}
