1class Solution {
2    
3    private boolean isPossible(int[] piles, double h, int speed) {
4        
5        double totalTime = 0;
6        for(int i = 0 ; i < piles.length ; i++){
7            totalTime += (Math.ceil((double)piles[i]/speed));
8        }
9
10        boolean ans = (h >= totalTime);
11        return ans;
12    }
13    
14    private int minEatingSpeed(int[] piles, int h, int minSpeed, int maxSpeed) {
15        
16        if(minSpeed > maxSpeed) return -1;
17
18        if(minSpeed == maxSpeed){
19            if(isPossible(piles, h, maxSpeed))
20                return maxSpeed; 
21            return -1;
22        }
23
24
25        int midSpeed = minSpeed + (maxSpeed - minSpeed)/2;
26        if(isPossible(piles, h, midSpeed)){
27            return minEatingSpeed(piles, h, minSpeed, midSpeed); 
28        }
29        return minEatingSpeed(piles, h, midSpeed + 1, maxSpeed); 
30    }
31
32    public int minEatingSpeed(int[] piles, int h) {
33        
34        if(piles.length > h) return -1;
35
36        int maxSpeed = 0;
37        for(int pile : piles){
38            maxSpeed = Math.max(maxSpeed, pile);
39        }
40
41        return minEatingSpeed(piles, h, 1, maxSpeed);  
42    }
43}