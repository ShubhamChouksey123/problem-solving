class LRUCache {

    class Node{
        public int key;
        public int value;
        public Node left;
        public Node right;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return "Node{"+key+","+value+"}";
        }
    }

    private Map<Integer, Node> mp;
    private int capacity;  
    private Node dummyLeft;
    private Node dummyRight;

    public LRUCache(int capacity) {

        mp = new HashMap<>();
        this.capacity = capacity;

        dummyLeft = new Node(-1, -1);
        dummyRight = new Node(100000, 100000);

        dummyLeft.right = dummyRight;
        dummyRight.left = dummyLeft;
        
    }
    
    public int get(int key) {
        
        System.out.println("getting key : " + key);
        Node node = mp.get(key);
        if(node == null){
            return -1;
        }
        
        // remove the element from that position
        removeNode(node);

        // add that at the start of the LL
        addNodeAtStart(node);
        // print();

        return node.value;
    }
    
    public void put(int key, int value) {
        System.out.println("adding key : " + key + " and value : " + value);
        Node node = mp.get(key);
        if(node != null){
           
            // udpate in the map
            node.value = value;

            // remove the element from that position
            removeNode(node);

            // add that at the start of the LL
            addNodeAtStart(node);

            // print();
            return;
        }

        Node newNode = new Node(key, value);
        
        // add that at the start of the LL
        addNodeAtStart(newNode);

        // add in the map
        mp.put(key, newNode);

        // capacity check and remove the last element of capacity exceeds the capacity limit 
        capacityUpdate();

        // print();
    }

    private void removeNode(Node node){
        Node leftNode = node.left;
        Node righNode = node.right;

        leftNode.right = righNode;
        righNode.left = leftNode;

        node.left = null;
        node.right = null;
    }

    private void addNodeAtStart(Node newNode){
        Node secondNode = dummyLeft.right;

        dummyLeft.right = newNode;
        newNode.left = dummyLeft;

        newNode.right = secondNode;
        secondNode.left = newNode;
    }

    private void capacityUpdate(){

        if(mp.size() <= capacity){
            return;
        }

        Node lastNode = dummyRight.left;
        Node secondLastNode = lastNode.left;

        secondLastNode.right = dummyRight;
        dummyRight.left = secondLastNode;

        mp.remove(lastNode.key);
    }

    private void print(){
        Node current = dummyLeft;
        while(current != null){
            System.out.print("("+current.key + "," + current.value + ") => ");
            current = current.right;
        }System.out.println(" ");

        current = dummyRight;
        while(current != null){
            System.out.print("("+current.key + "," + current.value + ") => ");
            current = current.left;
        }System.out.println(" ");

        System.out.println("mp : " + mp);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */