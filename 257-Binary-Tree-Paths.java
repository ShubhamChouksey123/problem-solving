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
    
    private void converToList(List<String> result, List<Integer> cur){
        if(cur.size() == 0) return;
        StringBuilder buidler = new StringBuilder();
        buidler.append(cur.get(0));

        for(int i = 1 ; i < cur.size() ; i++){
            buidler.append("->");
            buidler.append(cur.get(i));
        }
        result.add(buidler.toString());
    }

    public void binaryTreePaths(TreeNode root, List<String> result, List<Integer> cur) {
        
        if(root == null) return;
        if(root.left == null && root.right == null){
            cur.add(root.val);
            converToList(result, cur); 
            cur.remove(cur.size() - 1);
            return;
        }

        cur.add(root.val);

        binaryTreePaths(root.left, result, cur); 
        binaryTreePaths(root.right, result, cur); 

        cur.remove(cur.size() - 1);
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> result = new ArrayList<>();
        binaryTreePaths(root, result, new ArrayList<>());

        return result;
    }
}