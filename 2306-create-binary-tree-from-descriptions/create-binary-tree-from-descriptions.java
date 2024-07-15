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
    public TreeNode createBinaryTree(int[][] descriptions) {
        
        Map<Integer, TreeNode> nodes = new HashMap<>();
        // has parent = true;
        Map<Integer, Boolean> hasParents = new HashMap<>();

        for(int[] description : descriptions){

            int parentValue = description[0];
            int childValue  = description[1];

            TreeNode parentNode = nodes.get(parentValue);
            TreeNode childNode = nodes.get(childValue);
            if(parentNode == null){
                parentNode = new TreeNode(parentValue);
                nodes.put(parentValue, parentNode);
                hasParents.put(parentValue, false);
            }
            if(childNode == null){
                childNode = new TreeNode(childValue);
                nodes.put(childValue, childNode);
            }

            if(description[2] == 1){
                parentNode.left = childNode;
            }else{
                parentNode.right = childNode;
            }

            hasParents.put(childValue, true);
        }
        // System.out.println("hasParents : " + hasParents);

        for(Map.Entry<Integer, Boolean> entry : hasParents.entrySet()){
            if(Objects.equals(entry.getValue(), Boolean.FALSE)){
                return nodes.get(entry.getKey());
            }
        }

        return null;
    }
}