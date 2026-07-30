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


    private TreeNode lowestCommonAncestorNode;
    private boolean found;

    private Pair<Boolean, Boolean> lowestCommonAncestorUtil(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) return new Pair<>(false, false);

        Pair<Boolean, Boolean> leftResult = lowestCommonAncestorUtil(root.left, p, q);
        Pair<Boolean, Boolean> rightResult = lowestCommonAncestorUtil(root.right, p, q);

        Boolean pFound = (root == p) || leftResult.getKey() || rightResult.getKey();
        Boolean qFound = (root == q) ||leftResult.getValue() || rightResult.getValue();

        if(!found && pFound && qFound){
            lowestCommonAncestorNode = root; found = true;
        }
        return new Pair<>(pFound, qFound);    
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        found = false;
        lowestCommonAncestorNode = null;

        lowestCommonAncestorUtil(root, p, q);
        return lowestCommonAncestorNode;
    }
}