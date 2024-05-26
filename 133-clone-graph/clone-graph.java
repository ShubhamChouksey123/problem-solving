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
     private void createMapOfNode(Node node, Map<Node, Node> mappedNodes) {

        if (node == null)
            return;

        if (mappedNodes.containsKey(node)) {
            return;
        }
        Node mappedNode = new Node(node.val);
        mappedNodes.put(node, mappedNode);

        for (Node nodeSide : node.neighbors) {
            createMapOfNode(nodeSide, mappedNodes);
        }
    }

    private void connectCopyGraph(Node nodeOriginal, Map<Node, Node> mappedNodes, Set<Node> isVisited) {
        if (nodeOriginal == null)
            return;

        if (isVisited.contains(nodeOriginal)) {
            return;
        }

        isVisited.add(nodeOriginal);

        Node copyNode = mappedNodes.get(nodeOriginal);
        List<Node> neighborsCopy = new ArrayList<>();

        for (Node nodeSideOriginal : nodeOriginal.neighbors) {
            Node nodeSideCopy = mappedNodes.get(nodeSideOriginal);
            neighborsCopy.add(nodeSideCopy);
        }
        copyNode.neighbors = neighborsCopy;

        for (Node nodeSideOriginal : nodeOriginal.neighbors) {
            connectCopyGraph(nodeSideOriginal, mappedNodes, isVisited);
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> mappedNodes = new HashMap<>();
        createMapOfNode(node, mappedNodes);

//        System.out.println(mappedNodes);

        connectCopyGraph(node, mappedNodes, new HashSet<>());

        return mappedNodes.get(node);
    }
}