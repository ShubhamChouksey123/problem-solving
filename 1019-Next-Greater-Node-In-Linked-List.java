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
    public int[] nextLargerNodes(ListNode head) {
        
        ListNode current = head;
        List<Integer> list = new ArrayList<>();
        while(current != null){
            list.add(current.val);
            current = current.next;
        }

        int n = list.size();
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[n];
        Arrays.fill(ans, 0);

        for(int i = 0 ; i < n ; i++){
            while(!stack.isEmpty() && list.get(stack.peekLast()) < list.get(i)){
                ans[stack.pollLast()] = list.get(i);
            }
            stack.offerLast(i);
        }
        return ans;
    }
}