package leetcode;

/**
 * Created by HAOYUXING on 2020/7/7.
 */
public class Solution234 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    /**
     * 请判断一个链表是否为回文链表。
     *
     * 示例 1:
     *
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     *
     * 输入: 1->2->2->1
     * 输出: true
     * 进阶：
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     *
     * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
     */

    // 快慢指针找中点，边找边翻转前半段
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        // 如果最后fast不是空，则必然是奇数个，奇数忽略掉最中间的
        if (fast != null) {
            slow = slow.next;
        }

        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }

        return true;
    }


    // 计数法找中点
    public boolean isPalindromeV2(ListNode head) {
        // 计数
        int length = 0;
        ListNode dummy = head;
        while (dummy != null) {
            length++;
            dummy = dummy.next;
        }
        boolean even = length % 2 == 0;
        // 中点
        int mid = (length + 1) / 2;

        dummy = null;
        length = 0;
        // 翻转一半链表
        while (length < mid) {
            length++;
            ListNode next = head.next;
            head.next = dummy;
            dummy = head;
            head = next;
        }
        // 如果个数是奇数，忽略最中间再比较
        if (!even) dummy = dummy.next;

        while (dummy != null && head != null) {
            if (dummy.val != head.val) {
                return false;
            }
            dummy = dummy.next;
            head = head.next;
        }
        return true;
    }

}
