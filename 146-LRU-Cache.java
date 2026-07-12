class LRUCache {

    private Map<Integer, Node> keyToNode; 
    private int capacity;
    private Node start;
    private Node end;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyToNode = new HashMap<>();

        start = new Node(-1, -1);
        end = new Node(10001, 10001);

        start.prev = end;
        end.next = start; 
    }

    private void addAtStart(Node newNode){

        Node firstNode = start.prev;   
        firstNode.next = newNode;
        newNode.prev = firstNode;

        newNode.next = start;
        start.prev = newNode;
    }

    private void removeNode(Node node){

        Node prevNode = node.prev;   
        Node nextNode = node.next;   

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
    public int get(int key) {
        if(keyToNode.containsKey(key)){
            Node node = keyToNode.get(key);
            removeNode(node);
            addAtStart(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {

        if(keyToNode.containsKey(key)){
            Node node = keyToNode.get(key);
            removeNode(node);
            addAtStart(node);
            node.value = value;
            return;
        }

        Node newNode = new Node(key, value);
        // added to linked list
        addAtStart(newNode);
        // added to map
        keyToNode.put(key, newNode);

        if(keyToNode.size() > capacity){

            // removed from map
            keyToNode.remove(end.next.key);
            // removed from linked list
            removeNode(end.next);
        }
    }



    public class Node{
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */