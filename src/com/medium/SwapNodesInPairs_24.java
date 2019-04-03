// https://leetcode.com/problems/swap-nodes-in-pairs/

package com.medium;

public class SwapNodesInPairs_24 {

    public static void main(String[] args) {
        ListNode head = makeList(6);
        ListNode res = swapPairs(head);
        printList(res);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static ListNode makeList(int length) {
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 2; i <= length; i++) {
            ListNode next = new ListNode(i);
            node.next = next;
            node = next;
        }
        return head;
    }

    private static void printList(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + (node.next != null ? "->" : ""));
            node = node.next;
        }
    }

    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return  head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
