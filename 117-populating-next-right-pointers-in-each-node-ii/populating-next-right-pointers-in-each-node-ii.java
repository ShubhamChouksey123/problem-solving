/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    private void connect(Node root, List<Node> rightNode, int level) {

        if (root == null)
            return;

        if (rightNode.size() <= level) {
            rightNode.add(root);
        } else {
            root.next = rightNode.get(level);
            rightNode.set(level, root);
        }
        connect(root.right, rightNode, level + 1);
        /**
         * root.value
         */

        connect(root.left, rightNode, level + 1);

    }

    public Node connect(Node root) {

        if (root == null)
            return null;

        connect(root, new ArrayList<>(), 0);
        return root;
    }
}