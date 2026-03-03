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
12            if(sum == 0){
13                return false;
14            }
15            start = end + 1;
16            totalDays++;
17        }
18        if(totalDays <= days){
19            return true;
20        }
21        return false;
22    }
23
24    private int shipWithinDaysutil(int[] weights, int days, int startCapacity, int endCapacity) {
25
26        if(startCapacity == endCapacity){
27            return startCapacity;
28        }
29
30        int midCapacity = startCapacity + (endCapacity - startCapacity)/2;
31
32        if(isPossible(weights, days, midCapacity)){
33            return shipWithinDaysutil(weights, days, startCapacity, midCapacity); 
34        }
35        return shipWithinDaysutil(weights, days, midCapacity + 1, endCapacity); 
36        
37    }
38
39    public int shipWithinDays(int[] weights, int days) {
40
41        int startCapacity = 1;
42        int endCapacity = 0;
43
44        for(int weight : weights){
45            endCapacity += weight;
46        }
47
48        return shipWithinDaysutil(weights, days, startCapacity, endCapacity);
49    }
50}