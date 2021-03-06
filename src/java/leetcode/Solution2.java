package leetcode;

/**
 * Created by HAOYUXING on 2020/4/29.
 */
public class Solution2 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }


    /**
     * 2. 两数相加
     *
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
     * 并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     *
     * TAG: 链表
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode header = new ListNode(-1);
        ListNode temp = header;
        int jin = 0;
        while (l1 != null && l2 != null) {
            int res = l1.val + l2.val + jin;
            jin = res / 10;
            res = res % 10;
            ListNode node = new ListNode(res);
            temp.next = node;
            temp = node;

            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + jin;
            jin = sum / 10;
            sum = sum % 10;
            ListNode node = new ListNode(sum);
            temp.next = node;
            temp = node;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + jin;
            jin = sum / 10;
            sum = sum % 10;
            ListNode node = new ListNode(sum);
            temp.next = node;
            temp = node;
            l2 = l2.next;
        }
        if (jin > 0) {
            ListNode node = new ListNode(jin);
            temp.next = node;
        }

        return header.next;
    }

    // 上面有些重复代码, 优化一下
    public ListNode addTwoNumbersV2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int jin = 0;
        while (l1 != null || l2 != null) {
            int p = l1 != null ? l1.val : 0;
            int q = l2 != null ? l2.val : 0;
            int res = p + q + jin;
            jin = res / 10;
            res = res % 10;
            ListNode node = new ListNode(res);
            cur.next = node;
            cur = cur.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (jin > 0) {
            ListNode node = new ListNode(jin);
            cur.next = node;
        }
        return dummy.next;
    }
}
