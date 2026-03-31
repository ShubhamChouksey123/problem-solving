1class Solution {
2    public int numOfSubarrays(int[] arr, int k, int threshold) {
3        int n = arr.length, sum = 0, count = 0; 
4
5        for(int i = 0 ; i < k ; i++){
6            sum += arr[i];
7        }
8
9        if(sum / k >= threshold){
10            count++;
11        }
12
13        for(int i = k ; i < n ; i++){
14            sum += arr[i];
15            sum -= arr[i-k];
16            if(sum / k >= threshold){
17                count++;
18            }
19        }
20        return count;
21        
22    }
23}