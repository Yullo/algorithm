package leetcode;

/**
 * Created by HAOYUXING on 2022/7/13.
 */
public class Solution143 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
     *
     * L0 → L1 → … → Ln - 1 → Ln
     * 请将其重新排列后变为：
     *
     * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
     * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：head = [1,2,3,4]
     * 输出：[1,4,2,3]
     * 示例 2：
     *
     * 输入：head = [1,2,3,4,5]
     * 输出：[1,5,2,4,3] 
     *
     * 提示：
     *
     * 链表的长度范围为 [1, 5 * 104]
     * 1 <= node.val <= 1000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/reorder-list
     */

    public void reorderList(ListNode head) {
        // 翻转后半段，然后合并两个链表
        if (head == null) {
            return;
        }
        ListNode l1 = head;
        ListNode mid = findMid(head);

        ListNode l2 = mid.next;
        mid.next = null;

        ListNode nl2 = reveseNode(l2);

        mergeTwoNode(l1, nl2);
    }

    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reveseNode(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode n = cur.next;
            cur.next = pre;
            pre = cur;
            cur = n;
        }
        return pre;
    }

    public void mergeTwoNode(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode l1n = l1.next;
            ListNode l2n = l2.next;

            l1.next = l2;
            l1 = l1n;

            l2.next = l1n;
            l2 = l2n;
        }
    }

    public static void main(String[] args) {
        Solution143 solution143 = new Solution143();
        ListNode l5 = solution143.new ListNode(5);
        ListNode l4 = solution143.new ListNode(4, l5);
        ListNode l3 = solution143.new ListNode(3, l4);
        ListNode l2 = solution143.new ListNode(2, l3);
        ListNode l1 = solution143.new ListNode(1, l2);
        solution143.reorderList(l1);
    }
}
