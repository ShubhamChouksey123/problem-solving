/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    public Node cloneGraph(Node node, Map<Node, Node> actualToClonedNode) {

        if(node == null) return null;
        if(actualToClonedNode.containsKey(node)) return actualToClonedNode.get(node);

        Node root = new Node(node.val);
        System.out.println("root : " + root.val);
        actualToClonedNode.put(node, root);
        
        List<Node> clonedNeighbors = new ArrayList<>();
        for(Node actualNeighbour : node.neighbors){
            root.neighbors.add(cloneGraph(actualNeighbour, actualToClonedNode));
        } 

        return root;  
    }

    public Node cloneGraph(Node node) {

        if(node == null) return null;
        Map<Node, Node> actualToClonedNode = new HashMap<>();

        return cloneGraph(node, actualToClonedNode);
    }
}