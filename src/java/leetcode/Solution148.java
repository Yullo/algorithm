package leetcode;

/**
 * Created by HAOYUXING on 2020/6/16.
 */
public class Solution148 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    /**
     * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
     *
     * 示例 1:
     *
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     * 示例 2:
     *
     * 输入: -1->5->3->4->0
     * 输出: -1->0->3->4->5
     *
     * 链接：https://leetcode-cn.com/problems/sort-list
     */

    // 归并排序
    public ListNode sortList(ListNode head) {
        // 递归终止, 只有一个节点或无节点
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 平分数据
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        ListNode list1 = sortList(head);
        ListNode list2 = sortList(right);
        return merge(list1, list2);
    }

    // 合并两个链表
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode mv = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                mv.next = left;
                left = left.next;
            } else {
                mv.next = right;
                right = right.next;
            }
            mv = mv.next;
        }
        mv.next = left == null ? right : left;
        return dummy.next;
    }

}
