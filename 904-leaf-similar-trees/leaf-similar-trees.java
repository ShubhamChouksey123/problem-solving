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

    public void getLeafNodes(TreeNode root, List<Integer> leafs) {
        
        if(root == null){
            return;
        }

        getLeafNodes(root.left, leafs);
        if(root.left == null && root.right == null){
            leafs.add(root.val);
        }
        getLeafNodes(root.right, leafs);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        List<Integer> leafs1 = new ArrayList<>();
        getLeafNodes(root1, leafs1);

        List<Integer> leafs2 = new ArrayList<>();
        getLeafNodes(root2, leafs2);

        System.out.println("leafs1 : " + leafs1);
        System.out.println("leafs2 : " + leafs2);
        if(leafs1.size() != leafs2.size()){
            return false;
        }

        for(int i = 0 ; i < leafs1.size() ; i++){
            if(!Objects.equals(leafs1.get(i), leafs2.get(i))){
                return false;
            }
            
        }
        return true;
    }
}