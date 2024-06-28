/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    private int sum = 0;
    private Stack<Integer> st;

    private void sumEvenGrandparentUtil(TreeNode root) {
        if(root == null){
            return;
        }
        if(st.size() >= 2){
            int last = st.pop();
            int secondLast = st.peek();
            if(secondLast % 2 == 0){
                sum += root.val; 
            }
            st.push(last);
        }

        st.add(root.val);
        sumEvenGrandparentUtil(root.left);
        sumEvenGrandparentUtil(root.right);
        st.pop();
    }
    
    public int sumEvenGrandparent(TreeNode root) {
        st = new Stack<>();
        sum = 0;
        sumEvenGrandparentUtil(root) ;

        return sum;
    }
}