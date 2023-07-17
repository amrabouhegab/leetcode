package src;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(1, new ListNode(2)));
        System.out.println(deleteDuplicates(node).val);
        System.out.println(deleteDuplicates(node).next.val);
        ListNode node2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        System.out.println(deleteDuplicates(node2).val);
        System.out.println(deleteDuplicates(node2).next.val);
        System.out.println(deleteDuplicates(node2).next.next.val);
        System.out.println("========================================================");

        ListNode node3 = new ListNode(1, new ListNode(1, new ListNode(2)));
        System.out.println(deleteDuplicates_optimized(node3).val);
        System.out.println(deleteDuplicates_optimized(node3).next.val);
        ListNode node4 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        System.out.println(deleteDuplicates_optimized(node4).val);
        System.out.println(deleteDuplicates_optimized(node4).next.val);
        System.out.println(deleteDuplicates_optimized(node4).next.next.val);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode newList = dummy;
        Map<Integer, String> map = new HashMap<>();
        while (head != null) {
            if (!map.containsKey(head.val)) {
               map.put(head.val, "S");
               newList.next = new ListNode(head.val);
               newList = newList.next;
            }
           head = head.next;
        }
        return dummy.next;
    }

    public static ListNode deleteDuplicates_optimized(ListNode head) {
        ListNode dummy = head;
        while (dummy != null && dummy.next != null) {
            if (dummy.val == dummy.next.val) {
                dummy.next = dummy.next.next;
            } else {
                dummy = dummy.next;
            }
        }
        return head;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
