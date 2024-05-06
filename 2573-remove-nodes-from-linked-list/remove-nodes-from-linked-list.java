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
    private ListNode removeNodes(ListNode head, List<Integer> numbers, List<Integer> maxElementRight, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        for (int i = 0; i < n; i++) {
            if (numbers.get(i) < maxElementRight.get(i)) {
                /**
                 * remove this node
                 */
                current.next = current.next.next;
            } else
                current = current.next;
        }

        return dummy.next;
    }

    public ListNode removeNodes(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode current = head;
        List<Integer> numbers = new ArrayList<>();

        while (current != null) {
            numbers.add(current.val);
            current = current.next;
        }

        int n = numbers.size();
        List<Integer> maxElementRight = new ArrayList<>(numbers);
        maxElementRight.set(n - 1, Integer.MIN_VALUE);
        int maxValue = numbers.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            maxElementRight.set(i, maxValue);
            maxValue = Math.max(maxValue, numbers.get(i));
        }


        head = removeNodes(head, numbers, maxElementRight, n);

        return head;
    }
}