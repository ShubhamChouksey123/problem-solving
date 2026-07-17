class MyCircularDeque {

    private Deque<Integer> deque;
    private int size;

    public MyCircularDeque(int k) {
        deque = new ArrayDeque<>();
        size = k;
    }
    
    public boolean insertFront(int value) {
        
        if(deque.size() == size){
            return false;
        }
        deque.offerFirst(value);
        return true;
    }
    
    public boolean insertLast(int value) {
        if(deque.size() == size){
            return false;
        }
        deque.offerLast(value);
        return true;
    }
    
    public boolean deleteFront() {
        
        if(deque.size() == 0){
            return false;
        }
        deque.pollFirst();
        return true;
    }
    
    public boolean deleteLast() {
        
        if(deque.size() == 0){
            return false;
        }
        deque.pollLast();
        return true;
    }
    
    public int getFront() {
        if(deque.size() == 0){
            return -1;
        }
        return deque.peekFirst();
    }
    
    public int getRear() {
        if(deque.size() == 0){
            return -1;
        }
        return deque.peekLast();   
    }
    
    public boolean isEmpty() {
        return deque.isEmpty();
    }
    
    public boolean isFull() {
        return (deque.size() == size);
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */