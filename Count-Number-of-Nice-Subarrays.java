1class Solution {
2
3    /**
4        returns number of subarrays with max k off numbers
5     */
6    private int numberOfSubArraysWithMaxK(int[] nums, int k) {
7
8        // if(k == 0){
9        //     return 0;
10        // }
11
12        int n = nums.length, countOfOdds = 0, totalSubArray = 0;
13        int start = 0;
14
15        for(int end = 0 ; end < n ; end++){
16
17            if( (nums[end] & 1) != 0 ){
18                countOfOdds++;
19            }
20            while(start <= end && countOfOdds > k){
21                if( (nums[start] & 1) != 0 ){
22                    countOfOdds--;
23                }
24                start++;
25            }
26            
27            totalSubArray += (end - start + 1);
28            
29        }
30        return totalSubArray;
31    }
32
33    public int numberOfSubarrays(int[] nums, int k) {
34        return numberOfSubArraysWithMaxK(nums, k) - numberOfSubArraysWithMaxK(nums, k - 1);
35    }
36
37
38    
39}