class LRUCache {

    private Map<Integer, Node> keyToNode;   
    private int size;
    private int capacity; 
    private Node start;
    private Node end;

    public LRUCache(int capacity) {
        this.keyToNode= new HashMap<>();
        this.size = 0;
        this.capacity = capacity;
        this.start = new Node(100001, 100001);
        this.end = new Node(-1, -1);

        end.next = start;
        start.prev = end;
    }

    private void addAtStart(Node newNode){
        Node prevNode = start.prev;

        prevNode.next = newNode;
        newNode.prev = prevNode;

        newNode.next = start;
        start.prev = newNode;
        size++;
    }

    private void removeNode(Node node){

        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        size--;
    }
    
    public int get(int key) {
        
        if(!keyToNode.containsKey(key)){
            return -1;
        }

        Node node = keyToNode.get(key);
        removeNode(node);
        addAtStart(node);
        return node.value;
    }
    
    public void put(int key, int value) {


        if(!keyToNode.containsKey(key)){

            Node node = new Node(key, value);
            addAtStart(node);
            keyToNode.put(key, node);
    
        }
        else {
            Node node = keyToNode.get(key);
            node.value = value;
            removeNode(node);
            addAtStart(node);
        }
        
        
        if(size > capacity){
            Node nodeToRemove = end.next;
            removeNode(nodeToRemove);
            keyToNode.remove(nodeToRemove.key);
        }
        
    }


    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value, Node prev, Node next){
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next; 
        }

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