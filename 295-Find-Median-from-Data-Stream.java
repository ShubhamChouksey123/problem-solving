class MedianFinder {

    private Queue<Integer> minHeap;
    private Queue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
        );
    }
    
    public void addNum(int num) {
        
        if(maxHeap.size() == 0 || minHeap.size() == 0){
            maxHeap.add(num);
        }
        else if(minHeap.peek() <= num){
            minHeap.add(num);
        }
        else{
            maxHeap.add(num);
        }

        if(minHeap.size() - maxHeap.size() >= 2){
            int topElement = minHeap.poll();
            maxHeap.add(topElement);
        }
        else if(maxHeap.size() - minHeap.size() >= 2){
            int topElement = maxHeap.poll();
            minHeap.add(topElement);
        }
    }
    
    public double findMedian() {
        
        if(minHeap.size() > maxHeap.size()){
            return (double) minHeap.peek();
        }
        else if(minHeap.size() < maxHeap.size()){
            return (double) maxHeap.peek();
        }
        else if(minHeap.size() == maxHeap.size()){
            return ((double) minHeap.peek() + (double)maxHeap.peek()) / 2;
        }

        return 0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */