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
    
    public boolean findTargetUtil(TreeNode root, int k, Set<Integer> elements) {

        if(root == null){
            return false;
        }
        
        boolean foundLeft = findTargetUtil(root.left, k, elements);
        if(elements.contains(k - root.val)){
            return true;
        }
        elements.add(root.val);
        boolean foundRight =findTargetUtil(root.right, k, elements);

        return foundLeft | foundRight;
    }
    public boolean findTarget(TreeNode root, int k) {

        Set<Integer> elements = new HashSet<>();
        return findTargetUtil(root, k, elements); 
    }
}