/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }


        ListNode current1 = l1;
        ListNode current2 = l2;

        ListNode headSumList = new ListNode(0);
        ListNode currentSumList = headSumList;

        int carry = 0;
        while (current1 != null || current2 != null) {
            int sum = carry;
            if (current1 != null) {
                sum += current1.val;
                current1 = current1.next;
            }
            if (current2 != null) {
                sum += current2.val;
                current2 = current2.next;
            }

            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }

            currentSumList.next = new ListNode(sum);
            currentSumList = currentSumList.next;

        }
        if (carry == 1) {
            currentSumList.next = new ListNode(1);
            currentSumList = currentSumList.next;

        }

        return headSumList.next;
    }

}