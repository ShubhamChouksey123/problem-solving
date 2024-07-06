class MyHashMap {

    class Node{
        public int key; 
        public int value;
        public Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }

        public void setNext(Node next){
            this.next = next;
        }

        public String toString(){
            return "Node{" + "key:" + key + ",value:" + value+"}";
        }
    }

    private static final int CAPACITY = 5000;
    private Node[] nodes ;

    public MyHashMap() {
        nodes = new Node[CAPACITY]; 
    }
    
    public void put(int key1, int value) {
        Integer key = key1;
        int hash = key.hashCode() % CAPACITY;
        Node newNode = new Node(key, value);

        // first 
        if(nodes[hash] == null){
            nodes[hash] = newNode;
            return;
        }

        // nth
        Node current = nodes[hash];
        if(current.key == key1){
            current.value = value;
            return;
        }

        while(current.next != null && current.next.key != key1){
            current = current.next;
        }

        if(current.next != null && current.next.key == key1){
            current.next.value = value;
            return;
        }
        current.next = newNode;
    }
    
    public int get(int key1) {
        Integer key = key1;
        int hash = key.hashCode() % CAPACITY;

        // first
        if(nodes[hash] == null){
            return -1;
        }

        // nth
        Node current = nodes[hash];
        while(current != null && current.key != key){
            current = current.next;
        }
        
        if(current == null){
            return -1;
        }

        return current.value;        
    }
    
    public void remove(int key1) {
        Integer key = key1;
        int hash = key.hashCode() % CAPACITY;

        // first
        if(nodes[hash] == null){
            return;
        }

        // nth
        Node current = nodes[hash];

        if(current.key == key){
            nodes[hash] = current.next;
            return;
        }

        while(current.next != null && current.next.key != key){
            current = current.next;
        }
        if(current.next != null){
            current.next = current.next.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */