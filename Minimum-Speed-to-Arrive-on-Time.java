1class Solution {
2
3    private boolean isPossileToReach(int[] dist, double hour, int speed){
4
5        double time = 0; int n = dist.length;
6        for(int i = 0 ; i < n - 1 ; i++){
7            int d = dist[i];
8            time += Math.ceil((double)d/(double)speed);
9        }
10        time += (double)dist[n-1] / (double)speed; 
11        
12        return (time <= hour);
13    }
14
15    private int minSpeedOnTime(int[] dist, double hour, int minSpeed, int maxSpeed){
16
17        if(minSpeed > maxSpeed){
18            return -1;
19        }
20        
21        if(minSpeed == maxSpeed){
22            if(!isPossileToReach(dist, hour, minSpeed)){
23                return -1;
24            }
25            return minSpeed;
26        }
27
28        int midSpeed = minSpeed + (maxSpeed - minSpeed)/2;
29        
30        if(isPossileToReach(dist, hour, midSpeed)){
31            return minSpeedOnTime(dist, hour, minSpeed, midSpeed);
32        }
33        return minSpeedOnTime(dist, hour, midSpeed + 1, maxSpeed);
34    }
35
36    public int minSpeedOnTime(int[] dist, double hour) {
37        
38        return minSpeedOnTime(dist, hour, 1, 10000000); 
39    }
40}