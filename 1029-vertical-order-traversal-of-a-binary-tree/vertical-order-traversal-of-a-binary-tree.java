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

    class Node {
        int val;
        int x;
        int y;

        public Node(int val , int x, int y){
            this.val = val;
            this.x = x;
            this.y = y;
        }

        public String toString(){
            // return "Node{val:" +val+ ",x:" + x + ",y:" + y+"}"; 
            return "Node{val:" +val+ "}"; 
        }
        
    }


    private void inOrder(TreeNode root, int x, int depth, Map<Integer, List<Node>> mapOfNodes){
        if(root == null){
            return;
        }

        List<Node> currentList = mapOfNodes.get(x);
        Node newNode = new Node(root.val, x, depth);
        if(currentList == null){
            List<Node> newList = new ArrayList<>();
            newList.add(newNode);
            mapOfNodes.put(x, newList);
        }else{
            currentList.add(newNode);
        }

        inOrder(root.left, x - 1, depth + 1, mapOfNodes);
        inOrder(root.right, x + 1, depth + 1, mapOfNodes);
    }


    public List<List<Integer>> verticalTraversal(TreeNode root) {

        /**
        Map of x coordinate with the Nodes 
         */
        Map<Integer, List<Node>> mapOfNodes = new TreeMap<>();
        inOrder(root, 0, 0, mapOfNodes);

        List<List<Integer>> ans = new ArrayList<>();
        mapOfNodes.forEach(
            (k , v) -> {
                Collections.sort(v, (Node a, Node b) -> {
                    if(a.y != b.y){
                        return a.y - b.y;
                    }
                    return a.val - b.val;
                });
                List<Integer> column = new ArrayList<>();
                for(Node node : v){
                    column.add(node.val);
                }
                ans.add(column);
            }
        );


        // System.out.println("mapOfNodes : " + mapOfNodes);


        return ans;
    }
}