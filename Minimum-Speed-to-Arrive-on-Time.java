1class Solution {
2    
3    private boolean isPossible(int[] dist, double hour, int speed) {
4        
5        double time = 0;
6        int n = dist.length;
7        for(int i = 0; i < n - 1 ; i++){
8            time += (Math.ceil((double)dist[i]/speed));
9        }
10        time += ((double)dist[n - 1]/speed);
11
12        boolean ans = (time <= hour);
13        return ans;
14    }   
15
16    private int minSpeedOnTime(int[] dist, double hour, int start, int end) {
17        
18        
19        if(start > end) return -1;
20        if(start == end) {
21            if(isPossible(dist, hour, start)) return start;
22            return -1;
23        }    
24
25        int midSpeed = start + (end - start)/2;
26
27        if(isPossible(dist, hour, midSpeed)){
28            return minSpeedOnTime(dist, hour, start, midSpeed);
29        }        
30        return minSpeedOnTime(dist, hour, midSpeed + 1, end);
31    }
32    
33    public int minSpeedOnTime(int[] dist, double hour) {
34        
35        return minSpeedOnTime(dist, hour, 1, 1000000000); 
36    }
37}