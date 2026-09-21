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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        boolean leftToRight = true;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);

        while(!queue.isEmpty()){
            
            int size = queue.size();
            List<Integer> row = new LinkedList<>();
            for(int i = 0 ; i < size ; i++){
                TreeNode node = queue.pollFirst();
                if(leftToRight){
                    row.addLast(node.val);
                }
                else{
                    row.addFirst(node.val);
                }

                if(node.left != null) queue.offerLast(node.left);
                if(node.right != null) queue.offerLast(node.right);
            }

            
            leftToRight = !leftToRight;    
            result.add(row);

        }
        return result;

        
    }
}