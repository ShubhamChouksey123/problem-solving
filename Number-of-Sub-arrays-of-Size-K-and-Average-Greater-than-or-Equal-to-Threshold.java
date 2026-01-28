1class Solution {
2    public int numOfSubarrays(int[] arr, int k, int threshold) {
3
4        int n = arr.length, count = 0;
5        long sum = 0;
6        for(int i = 0 ; i < n ; i++){
7            sum += arr[i]; 
8            if(i >= k){
9                sum -= arr[i-k];
10            }
11            if(i + 1 >= k && sum / k  >= threshold){
12                count++;
13            }
14        }
15        return count;
16        
17    }
18}