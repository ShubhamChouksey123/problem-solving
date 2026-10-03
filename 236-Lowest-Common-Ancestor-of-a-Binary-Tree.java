/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private TreeNode lowestCommonAncestor;
    
    public Pair<Boolean, Boolean> lowestCommonAncestorUtil(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) return new Pair(false, false);

        Boolean pFound = (root == p) ? true : false;
        Boolean qFound = (root == q) ? true : false;

        Pair<Boolean, Boolean> left = lowestCommonAncestorUtil(root.left, p, q);
        Pair<Boolean, Boolean> right = lowestCommonAncestorUtil(root.right, p, q);

        pFound = pFound || left.getKey() || right.getKey(); 
        qFound = qFound || left.getValue() || right.getValue(); 

        if(lowestCommonAncestor == null && pFound && qFound){
            lowestCommonAncestor = root; return new Pair(true, true); 
        }
        return new Pair(pFound, qFound);  
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestor = null;
        lowestCommonAncestorUtil(root, p, q) ;
        return lowestCommonAncestor;
    }
}