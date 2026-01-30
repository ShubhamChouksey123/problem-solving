1class Solution {
2    
3    private int findBeauty(int[] count, int x){
4        int counter = 0;
5        for(int i = 50 ; i >= 0 ; i--){
6            if(count[i] > 0){
7                counter = counter + count[i];
8            }
9            if(counter >= x){
10                return -i;
11            }
12        }
13        return 0;
14    }
15
16
17    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
18        int n = nums.length;
19        int[] count = new int[51];
20        int[] ans = new int[n-k+1];
21
22        for(int i = 0 ; i < k ; i++){
23            if(nums[i] <= 0){
24                count[-1 * nums[i]]++;  
25            } 
26        }
27
28
29
30        ans[0] = findBeauty(count, x);
31        
32        for(int i = k ; i < n; i++){
33            if(nums[i] <= 0){
34                count[-1 * nums[i]]++;
35            }
36            if(nums[i-k] <= 0){
37                count[-1 * nums[i-k]]--;
38            }
39        
40            
41            ans[i-k+1] = findBeauty(count, x);
42        }
43
44        return ans;
45        
46    }
47}