class LRUCache {

    public class ListNode {

    public int key;
    public int val;
    public ListNode next;
    public ListNode previous;

    public ListNode() {
    }

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    }

    
    Map<Integer, ListNode> keyNode;
    ListNode dummyHead;
    ListNode dummyTail;

    ListNode currentHead;
    Integer capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        keyNode = new HashMap<>();
        dummyTail = new ListNode(0, 0);
        dummyHead = new ListNode(100, 100);

        dummyTail.next = dummyHead;
        dummyTail.previous = null;

        dummyHead.previous = dummyTail;
        dummyHead.next = null;

        currentHead = dummyTail;

    }

    public int get(int key) {

        ListNode node = keyNode.get(key);
        if (node != null) {
            moveNodeToStart(node);
            return node.val;
        }

        return -1;
    }

    public void put(int key, int value) {


        ListNode node = keyNode.get(key);
        if (node != null) {
            node.val = value;
            moveNodeToStart(node);
        } else {
            ListNode newNode = appendNodeAtStart(key, value);
            keyNode.put(key, newNode);
        }

        if (keyNode.size() > capacity) {
            keyNode.remove(dummyTail.next.key);
            removeLeftmostNode();
        }

    }

    private void removeLeftmostNode() {
        ListNode secondNode = dummyTail.next.next;

        secondNode.previous = dummyTail;
        dummyTail.next = secondNode;
    }

    private ListNode appendNodeAtStart(int key, int value) {

        ListNode newNode = new ListNode(key, value);
        currentHead.next = newNode;
        dummyHead.previous = newNode;
        newNode.next = dummyHead;
        newNode.previous = currentHead;

        currentHead = newNode;
        return currentHead;
    }

    private void moveNodeToStart(ListNode currentNode) {

        ListNode leftNode = currentNode.previous;
        ListNode rightNode = currentNode.next;

        leftNode.next = rightNode;
        rightNode.previous = leftNode;

        currentHead = dummyHead.previous;

        currentHead.next = currentNode;
        dummyHead.previous = currentNode;
        currentNode.next = dummyHead;
        currentNode.previous = currentHead;

        currentHead = currentNode;
    }


    private void traverseForward(ListNode head) {

        if (head != null) {
            System.out.print(head.val);
            head = head.next;
        }


        int count = 10;
        while (head != null && count > 0) {
            System.out.print(" -> " + head.val);
            head = head.next;
            count--;
        }
        System.out.println();

    }

    private void traverseBackward(ListNode head) {

        if (head != null) {
            System.out.print(head.val);
            head = head.previous;
        }


        int count = 10;
        while (head != null && count > 0) {
            System.out.print(" <- " + head.val);
            head = head.previous;
            count--;
        }
        System.out.println();

    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */