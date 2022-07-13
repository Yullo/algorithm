package leetcode;

/**
 * Created by HAOYUXING on 2020/5/18.
 */
public class Solution21 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    /**
     * 21. 合并两个有序链表
     *
     * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     *
     * 示例：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
     */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode dummy = temp;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                temp.next = l2;
                break;
            } else if (l2 == null) {
                temp.next = l1;
                break;
            } else if (l1.val <= l2.val) {
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
                temp = temp.next;
            } else {
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
                temp = temp.next;
            }

        }
        return dummy.next;
    }

    public ListNode mergeTwoList2(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0);
        ListNode cur = preHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return preHead.next;
    }
}
