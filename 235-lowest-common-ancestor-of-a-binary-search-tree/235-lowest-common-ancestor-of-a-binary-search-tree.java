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
    
    
    public void getAncestorList(TreeNode root, TreeNode p, List<TreeNode> list) {
        
        if(root == null){
            return ;
        }
        
        list.add(root);
        if(root.val == p.val){
            return ;
        }
        else if(root.right != null && root.val < p.val){
            getAncestorList( root.right,  p, list);
            return;
        }
        else{
            getAncestorList( root.left,  p, list);
            return;
        }
        
        
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode>  list1 = new ArrayList<>();
        List<TreeNode>  list2 = new ArrayList<>();
        
        getAncestorList( root,  p,  list1);
        getAncestorList( root,  q,  list2);
    
        
        TreeNode ans = root;
        for(int i = 0 ; i < Math.min(list1.size() , list2.size()) ; i++){
            if(list1.get(i) == (list2.get(i))  ){
                ans = list1.get(i);
            }
        }
        
        return ans;
        
    }
}