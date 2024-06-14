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
    private int goodNodesCount = 0;


    private void goodNodesUtil(TreeNode root, Stack<Integer> parents, Stack<Integer> maxValues) {
        if (root == null) {
            return;
        }

        if (root.val >= maxValues.peek()) {
            goodNodesCount++;
        }

        parents.add(root.val);
        if (root.val >= maxValues.peek()) {
            maxValues.add(root.val);
        } else {
            maxValues.add(maxValues.peek());
        }
        goodNodesUtil(root.left, parents, maxValues);
        goodNodesUtil(root.right, parents, maxValues);


        parents.pop();
        maxValues.pop();

    }

    public int goodNodes(TreeNode root) {

        TreeNode treeNode = new TreeNode(Integer.MIN_VALUE);
        
        Stack<Integer> parents = new Stack<>();
        parents.add(Integer.MIN_VALUE);
        Stack<Integer> maxValues = new Stack<>();
        maxValues.add(Integer.MIN_VALUE);

        goodNodesUtil(root, parents, maxValues);
        
        return goodNodesCount;
    }
}