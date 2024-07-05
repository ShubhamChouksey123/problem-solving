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

    private boolean isNextCriticalPoint(ListNode prev){
        if(prev == null || prev.next == null || prev.next.next == null){
            return false;
        }

        int prevValue = prev.val;
        int currentValue = prev.next.val;
        int nextValue = prev.next.next.val;
        if(currentValue > nextValue && currentValue > prevValue){
            return true;
        }
        if(currentValue < nextValue && currentValue < prevValue){
            return true;
        }
        return false;
    }

    private void updateMinMax(int[] ans, int firstIndex, int lastIndex, int index){
        if(ans[0] == -1){
            ans[0] = index - lastIndex;
        }else{
            ans[0] = Math.min(ans[0], index - lastIndex);
        }
        ans[1] = index - firstIndex;
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = new int[2];
        ans[0] = -1; ans[1] = -1;

        if(head == null || head.next == null){
            return ans;
        }

        ListNode dummy = new ListNode(head.val);
        dummy.next = head;
        ListNode current = dummy;
        
        int firstIndex = -1,lastIndex = -1,index = 0;
        
        while(current != null && current.next != null){
            if(isNextCriticalPoint(current)){
                if(firstIndex == -1){
                    firstIndex = index;lastIndex = index;    
                }else {
                    updateMinMax(ans, firstIndex, lastIndex, index);
                    lastIndex = index;
                }
            }
            index++;
            current = current.next;
        }

        return ans;

    }
}