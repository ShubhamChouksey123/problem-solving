1class Solution {
2
3    private Queue<Integer> largerHalf = new PriorityQueue<>();
4    private Queue<Integer> smallerHalf = new PriorityQueue<>(
5        (a, b) -> Integer.compare(b, a)
6    );
7    private Map<Integer, Integer> count = new HashMap<>();
8
9    private double getMedian(int k){
10        if( (k & 1) != 0  && !smallerHalf.isEmpty()){
11            return (double)smallerHalf.peek();
12        }
13        return ((double)smallerHalf.peek() + (double)largerHalf.peek()) / 2.0; 
14    }
15
16    private void prune(Queue<Integer> heap){
17        while(!heap.isEmpty() && count.getOrDefault(heap.peek(), 0) > 0){
18            Integer topElement = heap.poll();
19            count.put(topElement, count.get(topElement) - 1);
20        }
21    }
22
23    private void rebalance(int balance){
24        if(balance < 0){
25            smallerHalf.add(largerHalf.poll());
26        }
27        else if(balance > 0){
28            largerHalf.add(smallerHalf.poll());
29        }
30    }
31
32
33    public double[] medianSlidingWindow(int[] nums, int k) {
34
35        int n = nums.length;
36        double[] ans = new double[n- k + 1];
37
38        for(int i = 0 ; i < k ; i++){
39            smallerHalf.add(nums[i]);
40        }
41        for(int i = 0 ; i < k/2 ; i++){
42            largerHalf.add(smallerHalf.poll());
43        }
44
45        for(int i = k ; i <= n ; i++){
46            
47            ans[i-k] = getMedian(k);
48            if(i == nums.length)
49                break;
50
51            int outElement = nums[i - k];
52            int inElement = nums[i];
53
54            int balance = 0;
55            count.put(outElement, count.getOrDefault(outElement, 0) + 1);
56
57            if(outElement <= smallerHalf.peek()){
58                balance--;
59            }
60            else {
61                balance++;
62            }
63
64            if(smallerHalf.isEmpty() ||  inElement <= smallerHalf.peek()){
65                balance++;
66                smallerHalf.add(inElement);
67            }
68            else {
69                balance --;
70                largerHalf.add(inElement);
71            } 
72
73            rebalance(balance);
74            prune(smallerHalf);
75            prune(largerHalf);
76
77        }
78        return ans;
79    }
80}