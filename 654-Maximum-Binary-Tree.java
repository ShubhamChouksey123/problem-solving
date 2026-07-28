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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        for(int num : nums){
            TreeNode cur = new TreeNode(num);

            while(!stack.isEmpty() && stack.peekLast().val < num){
                cur.left = stack.pollLast(); 
            }

            if(!stack.isEmpty()){
                stack.peekLast().right = cur;
            }

            stack.offerLast(cur);
        }

        return (stack.isEmpty()) ? null : stack.pollFirst();
    }
}