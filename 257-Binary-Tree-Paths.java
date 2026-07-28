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
    
    private void addToList(List<Integer> cur, List<String> ans){
        if(cur.isEmpty()) return;

        StringBuilder builder = new StringBuilder();
        builder.append(cur.get(0));

        for(int i = 1 ; i < cur.size() ; i++){
            builder.append("->");
            builder.append(cur.get(i));
        }  
        ans.add(builder.toString()); 
    }

    public void binaryTreePaths(TreeNode root, List<Integer> cur, List<String> ans) {
        
        if(root == null) return;
        cur.add(root.val);

        if(root.left == null && root.right == null) {
            addToList(cur, ans);
            return;
        }
            
        if(root.left != null){
            binaryTreePaths(root.left, cur, ans);
            cur.remove(cur.size() - 1);
        }

        if(root.right != null){
            binaryTreePaths(root.right, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        binaryTreePaths(root, new ArrayList<>(), ans); 

        return ans;
    }
}