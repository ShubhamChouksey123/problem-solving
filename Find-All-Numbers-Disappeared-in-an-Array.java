1class Solution {
2    public List<Integer> findDisappearedNumbers(int[] nums) {
3        int n = nums.length;
4        List<Integer> ans = new ArrayList<>();
5        for(int i = 0 ; i < n ; i++){
6            int index = Math.abs(nums[i]) - 1;
7            if(nums[index] > 0){
8                nums[index] = -nums[index];
9            }
10            
11        }
12
13        for(int i = 0 ; i < n ; i++){
14            if(nums[i] > 0){
15                ans.add(i+1);
16            }
17        }
18        return ans;
19    }
20}