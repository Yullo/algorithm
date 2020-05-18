package leetcode;

/**
 * Created by HAOYUXING on 2020/5/18.
 */
public class Solution23 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    /**
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     *
     * 示例:
     *
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     *
     * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
     */

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        int l = 0;
        int r = lists.length - 1;

        // 两两比较，总共需要 N -1 次
        for (int i = 0; i < lists.length - 1; i++) {
            lists[l] = mergeTwoLists(lists[l], lists[r]);
            l++;
            r--;
            if (l >= r) l = 0;
        }
        return lists[0];
    }

    // 合并两个链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode dummy = temp;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

}
