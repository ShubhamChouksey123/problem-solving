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
    
    private int maxSumValueLevel = Integer.MIN_VALUE;
    private int maxSumNumberLevel = 0;

    public void maxLevelSumUtil(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1, currentLevelSum = 0;

        queue.add(root);
        queue.add(null);
    
        while(!queue.isEmpty()){

            TreeNode top = queue.poll();
           
            if(top == null){
            
                if(currentLevelSum > maxSumValueLevel){
                    maxSumValueLevel = currentLevelSum;
                    maxSumNumberLevel = level;
                }
                currentLevelSum = 0;
                level++;
                if(!queue.isEmpty()){
                    queue.add(null);
                }
                continue;
            }

            currentLevelSum += top.val;
            
            if(top.left != null){
                queue.add(top.left);
            }
            if(top.right != null){
                queue.add(top.right);
            }
        }
    }

    public int maxLevelSum(TreeNode root) {
        this.maxSumValueLevel = 1;
        this.maxSumValueLevel = Integer.MIN_VALUE;
        maxLevelSumUtil(root);
        return maxSumNumberLevel;

    }
}