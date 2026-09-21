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

    public class Node{
        int row;
        int col;
        int val;

        public Node(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    private void inOrder(TreeNode root, List<Node> nodes, int row, int col){

        if(root == null) return;

        nodes.add(new Node(row, col, root.val));
        
        inOrder(root.left, nodes, row - 1, col + 1);
        inOrder(root.right, nodes, row + 1, col + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        List<Node> nodes = new ArrayList<>();
        inOrder(root, nodes, 0, 0);

        Collections.sort(nodes, (a, b) -> {
            if(a.row != b.row) return Integer.compare(a.row, b.row);
            if(a.col != b.col) return Integer.compare(a.col, b.col);
            return Integer.compare(a.val, b.val);
        });


        Map<Integer, List<Integer>> colToNodes = new TreeMap<>();

        for(Node node : nodes){

            int row = node.row;
            if(colToNodes.containsKey(row)){
                colToNodes.get(row).add(node.val);
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                colToNodes.put(row, list);
            }
        }
    
        for(List<Integer> list : colToNodes.values()){
            result.add(list);
        }
        return result;
    }   
}