/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    
    public Node appendNode(Node copyCurrent, Node originalNode, int index, Map<Node, Integer> originalNodeIndex, Map<Integer, Node> copyIndexNode) {

        if (originalNode == null)
            return null;

        copyCurrent.next = new Node(originalNode.val);
        copyCurrent = copyCurrent.next;

        originalNodeIndex.put(originalNode, index);
        copyIndexNode.put(index, copyCurrent);

        return copyCurrent;
    }

    private void connectNodes(Node originalCurrent, Node copyCurrent, Map<Node, Integer> originalNodeIndex, Map<Integer, Node> copyIndexNode) {

        while (originalCurrent != null) {
            if (originalCurrent.random != null) {
                int indexConnectedNode = originalNodeIndex.get(originalCurrent.random);
                copyCurrent.random = copyIndexNode.get(indexConnectedNode);
            }
            originalCurrent = originalCurrent.next;
            copyCurrent = copyCurrent.next;
        }
    }

    public Node copyRandomList(Node head) {

        if (head == null)
            return null;


        Map<Node, Integer> originalNodeIndex = new HashMap<>();
        Map<Integer, Node> copyIndexNode = new HashMap<>();
        Node currentOriginal = head;
        Node dummy = new Node(0);
        Node currentCopy = dummy;
        int index = 0;
        while (currentOriginal != null) {
            currentCopy = appendNode(currentCopy, currentOriginal, index, originalNodeIndex, copyIndexNode);
            currentOriginal = currentOriginal.next;
            index++;
        }

        connectNodes(head, dummy.next, originalNodeIndex, copyIndexNode);

        return dummy.next;

    }
}