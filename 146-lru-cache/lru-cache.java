class LRUCache {

    public class Node{

        public int key;
        public int value;
        public Node left;
        public Node right;

        public Node(){

        }

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }

        public void setValue(int value){
            this.value = value;
        }

        @Override
        public String toString(){
            return "Node:(" + this.key + ","+ this.value+")";
        }
    }

    /**
     * map of
     * key -> Node(key, value)
     */
    private Map<Integer, Node> lookUp ;
    private Integer capacity;
    private Node dummyHead;
    private Node dummyTail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        lookUp = new HashMap<>();

        dummyHead = new Node(-100, -100);
        dummyTail = new Node(-200, -200);

        dummyHead.right = dummyTail;
        dummyTail.left = dummyHead;
    }

    public int get(int key) {

        // System.out.println("get key : " + key);
        Node node = lookUp.get(key);
        
        if(node == null){
            return -1;  
        }
    
        removeNode(node);
        addNodeAtStart(dummyHead, node);

        // print();
        return node.value;
    }

    public void put(int key, int value) {

        // System.out.println("put key : " + key + " and value : " + value);
        Node node = lookUp.get(key);
        if(node != null){
            // update the value with that key
            node.setValue(value);
            lookUp.put(key, node);

            removeNode(node);
            addNodeAtStart(dummyHead, node);
            return ;
        }

        // insert the {key, value} in the map and in the linkedlist
        Node newNode = new Node(key, value);
        addNodeAtStart(dummyHead, newNode);
        lookUp.put(key, newNode);
        
        udpateCapcity();
        // print();
    }

    private void addNodeAtStart(Node dummyHead, Node newNode){


        Node rightNode = dummyHead.right;

        dummyHead.right = newNode;
        newNode.left = dummyHead;

        newNode.right = rightNode;
        rightNode.left = newNode;
    }

    private void udpateCapcity(){
        if(lookUp.size() > capacity){
            Node lastNode = dummyTail.left;
            lookUp.remove(lastNode.key);
            evictLastElement();   
        }
    }

    private void removeNodeAtLast(Node dummyTail){

        Node lastNode = dummyTail.left;
        Node secondLastNode = lastNode.left;

        secondLastNode.right = dummyTail;
        dummyTail.left = secondLastNode;
    }

    private void removeNode(Node node){

        Node previousNode = node.left;
        Node nextNode = node.right;
        
        previousNode.right = nextNode;
        nextNode.left = previousNode;
    }

    private void evictLastElement(){
        removeNodeAtLast(dummyTail);
    }

    private void print(){
        Node head = dummyHead;
        while(head != null){
            System.out.print("element (" + head.key
                    + ","+head.value + ")-> ");
            head = head.right;
        }
        System.out.println(" " );
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */