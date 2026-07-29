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

    private void pathSumUtil(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> cur, int ancestralSum){

        if(root == null) return;

        cur.add(root.val);
        ancestralSum += root.val;

        if(root.left == null && root.right == null){
            if(ancestralSum == targetSum){
                ans.add(new ArrayList<>(cur));
            }
        }

        pathSumUtil(root.left, targetSum, ans, cur, ancestralSum);
        pathSumUtil(root.right, targetSum, ans, cur, ancestralSum);
        
        cur.remove(cur.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> ans = new ArrayList<>();
        pathSumUtil(root, targetSum, ans, new ArrayList<>(), 0);
        return ans;
    }
}