1class Solution {
2
3    private boolean isPossible(int[] weights, int days, int capacity) {
4        int start = 0, end = -1, n = weights.length; 
5        int totalDays = 0;
6        while(start < n){
7            int sum = 0;
8            while(end + 1 < n && sum + weights[end + 1] <= capacity){
9                sum += weights[end + 1];
10                end++; 
11            }
12            start = end + 1;
13            totalDays++;
14        }
15        if(totalDays <= days){
16            return true;
17        }
18        return false;
19    }
20
21    private int shipWithinDaysutil(int[] weights, int days, int startCapacity, int endCapacity) {
22
23        if(startCapacity == endCapacity){
24            return startCapacity;
25        }
26
27        int midCapacity = startCapacity + (endCapacity - startCapacity)/2;
28
29        if(isPossible(weights, days, midCapacity)){
30            return shipWithinDaysutil(weights, days, startCapacity, midCapacity); 
31        }
32        return shipWithinDaysutil(weights, days, midCapacity + 1, endCapacity); 
33        
34    }
35
36    public int shipWithinDays(int[] weights, int days) {
37
38        int startCapacity = 1;
39        int endCapacity = 0;
40
41        for(int weight : weights){
42            endCapacity += weight;
43            startCapacity = Math.max(startCapacity, weight);
44        }
45
46        return shipWithinDaysutil(weights, days, startCapacity, endCapacity);
47    }
48}