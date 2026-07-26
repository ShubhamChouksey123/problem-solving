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
    public TreeNode reverseOddLevels(TreeNode root) {

        if(root == null) return root;
        
        List<TreeNode> currentList = new ArrayList<>();
        currentList.add(root);

        List<TreeNode> nextList = new ArrayList<>();
        int depth = 0;

        while(!currentList.isEmpty()){

            int size = currentList.size();
            nextList = new ArrayList<>();

            if(depth % 2 != 0){
                for(int i = 0 ; i < size /2 ; i++){
                    int tmp = currentList.get(i).val;
                    currentList.get(i).val = currentList.get(size - i - 1).val;
                    currentList.get(size - i - 1).val = tmp;
                }
            }

            for(int i = 0 ; i < size ; i++){
                if(currentList.get(i).left != null) nextList.add(currentList.get(i).left);
                if(currentList.get(i).right != null) nextList.add(currentList.get(i).right);
            }

            currentList = nextList;
            depth++;
        }
        return root;
    }
}