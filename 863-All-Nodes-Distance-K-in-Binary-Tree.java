/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    
    private void preOrder(TreeNode root, Map<TreeNode, TreeNode> nodeToParent){

        if(root == null) return;

        if(root.left != null) nodeToParent.put(root.left, root);
        if(root.right != null) nodeToParent.put(root.right, root);

        preOrder(root.left, nodeToParent);
        preOrder(root.right, nodeToParent);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Map<TreeNode, TreeNode> nodeToParent = new HashMap<>();
        preOrder(root, nodeToParent);


        Deque<TreeNode> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>(); 

        queue.offerLast(target);
        visited.add(target.val);
        int distance = 0;
        
        while(!queue.isEmpty()){
            if(distance == k){
                while(!queue.isEmpty()) ans.add(queue.pollFirst().val);
                break;
            }
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode node = queue.pollFirst();

                if(node.left != null && !visited.contains(node.left.val)){
                    queue.offerLast(node.left);
                    visited.add(node.left.val);
                }
                if(node.right != null && !visited.contains(node.right.val)){
                    queue.offerLast(node.right);
                    visited.add(node.right.val);
                }
                if(nodeToParent.containsKey(node) && !visited.contains(nodeToParent.get(node).val)){
                    queue.offerLast(nodeToParent.get(node));
                    visited.add(nodeToParent.get(node).val);
                }
            }
            distance++;
        }
        return ans;
    }
}