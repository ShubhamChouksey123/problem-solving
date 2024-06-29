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
    
    /**
    @param start : startIndex
    @param end : endIndex
     */
    private TreeNode insert(int[] nums, int start, int end) {
        if (start == end){
            return new TreeNode(nums[start]);
        }
        if(start + 1 == end){
            return new TreeNode(nums[end], new TreeNode(nums[start]), null);
        }

        int mid = (start + end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left  = insert(nums, start, mid-1); 
        root.right = insert(nums, mid+1, end); 
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return insert(nums, 0, nums.length -1);
    }
}