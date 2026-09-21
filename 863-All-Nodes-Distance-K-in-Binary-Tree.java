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

    private void inOrder(TreeNode root, Map<TreeNode, TreeNode> nodeToParent) {

        if(root == null) return ;

        if(root.left != null) nodeToParent.put(root.left, root);
        if(root.right != null) nodeToParent.put(root.right, root);
        
        inOrder(root.left, nodeToParent);
        inOrder(root.right, nodeToParent);
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Map<TreeNode, TreeNode> nodeToParent = new HashMap<>();
        inOrder(root, nodeToParent);

        

        Set<TreeNode> visited = new HashSet<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(target);
        visited.add(target);

        int distance = 0;

        while(!queue.isEmpty()){

            if(distance == k){
                while(!queue.isEmpty()){
                    result.add(queue.pollFirst().val);
                } break;
            }

            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                TreeNode node = queue.pollFirst();
                if(node.left != null && !visited.contains(node.left)){
                    visited.add(node.left);
                    queue.offerLast(node.left);
                }
                if(node.right != null && !visited.contains(node.right)){
                    visited.add(node.right);
                    queue.offerLast(node.right);
                }
                TreeNode parnetNode = nodeToParent.get(node);
                if(parnetNode == null) continue;

                if(!visited.contains(parnetNode) ){
                    visited.add(parnetNode);
                    queue.offerLast(parnetNode);
                }

            }
            distance++;
        }
        return result;
    }
}