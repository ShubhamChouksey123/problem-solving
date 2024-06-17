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

    public class Pair{
        public int left;
        public int right;

        public Pair(int left, int right){
            this.left = left;
            this.right = right;
        }

    }

    private int longestZigZag ;

    private Pair longestZigZagUtil(TreeNode root) {
        
        if(root == null){
            return null;
        }
        System.out.println("finding for : " + root.val);

        if(root.left == null && root.right == null){
            return new Pair(0, 0);
        }

        Pair leftPair = new Pair(-1, -1);
        if(root.left != null){
            leftPair = longestZigZagUtil(root.left);
        }

        Pair rightPair = new Pair(-1, -1);
        if(root.right != null){
            rightPair = longestZigZagUtil(root.right);
        }

        this.longestZigZag = Math.max(Math.max(leftPair.right + 1, rightPair.left + 1), this.longestZigZag); 
        // System.out.println("root : " + root.val + " has left : " + (leftPair.right + 1) + " and right : " + (rightPair.left + 1) );
        // System.out.println("longestZigZag : " + longestZigZag);
        return new Pair(leftPair.right + 1, rightPair.left + 1);
    }

    public int longestZigZag(TreeNode root) {
        
        this.longestZigZag = 0;
        Pair rootPair = longestZigZagUtil(root);
        return Math.max(Math.max(rootPair.left, rootPair.right), this.longestZigZag);
    }
}