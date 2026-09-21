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
    
    public void pathSum(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> cur, int sum) {
        
        if(root == null) return;

        if(root.left == null && root.right == null){

            cur.add(root.val);
            sum += root.val;

            if(sum == targetSum) {
                result.add(new ArrayList<>(cur));
            }

            cur.remove(cur.size() - 1);
            sum -= root.val;
        }

        cur.add(root.val);
        sum += root.val;

        pathSum(root.left, targetSum, result, cur, sum);
        pathSum(root.right, targetSum, result, cur, sum);

        cur.remove(cur.size() - 1);
        sum -= root.val;
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();   
        pathSum(root, targetSum, result, new ArrayList<>(), 0);
        return result;
    }
}