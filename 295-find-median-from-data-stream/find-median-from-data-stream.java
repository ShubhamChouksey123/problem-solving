class MedianFinder {

    private Queue<Integer> greatElements;
    private Queue<Integer> smallerElements;

    public MedianFinder() {
        
        greatElements = new PriorityQueue<>();
        smallerElements = new PriorityQueue<>(
            (a,b) -> {
                return b - a;
            }
        );

        smallerElements.add(-100001);
        greatElements.add(100001);
        
    }
    
    public void addNum(int num) {

        if(num < smallerElements.peek()){
            smallerElements.add(num);
        } 
        else if(num > greatElements.peek()){
            greatElements.add(num);
        }else{
            smallerElements.add(num);
        }

        makeSizeEqual();
    }
    
    public double findMedian() {
        
        int smallQSize = smallerElements.size();
        int greaterQSize = greatElements.size();
    

        if(smallQSize > 1 && greaterQSize > 1){

            if(smallQSize == greaterQSize){
                return ((double)smallerElements.peek() + (double)greatElements.peek()) / 2.0;
            } 
            else if(smallQSize > greaterQSize){
                return (double)smallerElements.peek();
            }
            return (double)greatElements.peek();
            
        }
        else if(smallQSize == 1){
            return (double)greatElements.peek();
        }
        else if(greaterQSize == 1){
            return (double)smallerElements.peek();
        }
        
        return 0.0;
    }

    private void makeSizeEqual(){
        int smallQSize = smallerElements.size();
        int greaterQSize = greatElements.size();

        if(Math.abs(smallQSize - greaterQSize) <= 1){
            return;
        }

        if(smallQSize > greaterQSize){
            int top = smallerElements.poll();
            greatElements.add(top);
        }
        else if(smallQSize < greaterQSize){
            int top = greatElements.poll();
            smallerElements.add(top);
        }
    } 
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */