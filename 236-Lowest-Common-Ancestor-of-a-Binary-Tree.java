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

    private TreeNode lowCommonAncestor;

    public Pair<Boolean, Boolean> lowestCommonAncestorUtil(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) return new Pair<>(false, false);

        Boolean pFound = false, qFound = false;
        if(root == p) pFound = true;
        if(root == q) qFound = true;

        Pair<Boolean, Boolean> left = lowestCommonAncestorUtil(root.left, p, q);
        Pair<Boolean, Boolean> right = lowestCommonAncestorUtil(root.right, p, q);

        pFound = pFound || left.getKey() || right.getKey();
        qFound = qFound || left.getValue() || right.getValue();        

        if(pFound && qFound && lowCommonAncestor == null){
            lowCommonAncestor = root;
        }
        return new Pair<>(pFound, qFound);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        lowCommonAncestor = null;
        lowestCommonAncestorUtil(root, p, q);
        return lowCommonAncestor;
    }
}