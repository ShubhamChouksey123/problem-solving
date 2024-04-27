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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrders = new ArrayList<>();

        if (root == null)
            return levelOrders;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        List<Integer> row = new ArrayList<>();

        while (!queue.isEmpty()) {

            TreeNode top = queue.poll();

            if (top == null) {
                levelOrders.add(row);
                row = new ArrayList<>();

                if(!queue.isEmpty()){
                    queue.add(null);
                }
                continue;
            }

            row.add(top.val);
            if (top.left != null) {
                queue.add(top.left);
            }
            if (top.right != null) {
                queue.add(top.right);
            }

        }

        System.out.println("levelOrders " + levelOrders);

        return levelOrders;   
    }
}