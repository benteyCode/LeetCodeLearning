package com.bentey.leetcodelearning.list;


import com.bentey.leetcodelearning.model.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * yinyu
 * 2024/7/26
 */
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return true;
        }

        List<Integer> container = new ArrayList<>();

        while (head != null) {
            container.add(head.val);
            head = head.next;
        }

        int i = 0;
        int j = container.size() - 1;

        while (i < j) {
            if (container.get(i) != container.get(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }

        return true;
    }

    public boolean isPalindrome1(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode firstEndNode = getFirstEndNode(head);
        ListNode secondReverseList = reverseList(firstEndNode.next);

        ListNode front = head;
        ListNode end = secondReverseList;

        while (end != null) {
            if (front.val != end.val) {
                return false;
            }
            front = front.next;
            end = end.next;
        }

        secondReverseList = reverseList(secondReverseList);
        return true;
    }

    public ListNode getFirstEndNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next.next != null && slow.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

}
