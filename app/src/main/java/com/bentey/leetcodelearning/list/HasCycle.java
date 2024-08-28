package com.bentey.leetcodelearning.list;

import com.bentey.leetcodelearning.model.ListNode;

import java.util.HashMap;

/**
 * yinyu
 * 2024/7/26
 */
public class HasCycle {

    /**
     * hash
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        HashMap<ListNode, Integer> container = new HashMap<>();

        ListNode pA = head;

        int index = 0;
        while (pA != null) {
            if (container.containsKey(pA)) {
                return true;
            }
            container.put(pA, index);
            pA = pA.next;
            index++;
        }
        return false;
    }

    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

}
