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
    

    private void getAncestors(TreeNode root, TreeNode p, List<TreeNode> parents, List<TreeNode> parentsFinal) {

        if(root == null){
            return;
        }

        parents.add(root);
        if(root == p){
            parentsFinal.addAll(parents);
            return ;
        }

        getAncestors(root.left, p, parents, parentsFinal) ;
        getAncestors(root.right, p, parents, parentsFinal) ;

        parents.remove(parents.size() -1);
    }

    private void print(List<TreeNode> parents){
        for(TreeNode treeNode : parents){
            System.out.print(treeNode.val + " ");
        }
         System.out.println();
    }

    private TreeNode lowestCommonAncestor(List<TreeNode> parentsP, List<TreeNode> parentsQ) {
        
        TreeNode ans = null;
        for(int i = 0 ; i < Math.min(parentsP.size(), parentsQ.size()) ; i++){
            if(parentsP.get(i) != parentsQ.get(i)){
                break;
            }
            ans = parentsP.get(i);
        }
        return ans;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> parentsP = new ArrayList<>();
        List<TreeNode> parentsQ = new ArrayList<>();

        getAncestors(root, p, new ArrayList<>(), parentsP);
        getAncestors(root, q, new ArrayList<>(), parentsQ);

        // print(parentsP);
        // print(parentsQ);

        return lowestCommonAncestor(parentsP,  parentsQ);
    }
}