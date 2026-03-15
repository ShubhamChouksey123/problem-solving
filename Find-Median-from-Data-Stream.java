1class MedianFinder {
2
3    private Queue<Integer> minHeap;
4    private Queue<Integer> maxHeap;
5
6    public MedianFinder() {
7        minHeap = new PriorityQueue<>();
8        maxHeap = new PriorityQueue<>(
9            (Integer a, Integer b) -> Integer.compare(b, a)
10        );
11
12        minHeap.add(Integer.MAX_VALUE);
13        maxHeap.add(Integer.MIN_VALUE);
14    }
15    
16    public void addNum(int num) {
17
18        if(minHeap.peek() <= num){
19            minHeap.add(num);
20        } 
21        else{
22            maxHeap.add(num);
23        }
24          
25        if(maxHeap.size() - minHeap.size() > 1){
26            minHeap.add(maxHeap.poll());
27            return; 
28        }
29
30        if(minHeap.size() - maxHeap.size() > 1){
31            maxHeap.add(minHeap.poll());
32        }
33    }
34    
35    public double findMedian() {
36
37        if(((maxHeap.size() + minHeap.size()) & 1) != 0){
38            if(maxHeap.size() > minHeap.size()){
39                return (double)maxHeap.peek();   
40            }
41            return (double)minHeap.peek();   
42        }
43
44        double result = 0.0;
45        if(!maxHeap.isEmpty()){
46            result += maxHeap.peek();
47        }
48        if(!minHeap.isEmpty()){
49            result += minHeap.peek();
50        }
51
52        return (double) result/2;
53        
54    }
55}
56
57/**
58 * Your MedianFinder object will be instantiated and called as such:
59 * MedianFinder obj = new MedianFinder();
60 * obj.addNum(num);
61 * double param_2 = obj.findMedian();
62 */