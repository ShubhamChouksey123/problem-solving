1class Solution {
2    public int findDuplicate(int[] nums) {
3
4        int n = nums.length, slow = 0, fast = 0;
5        fast = nums[fast];
6        fast = nums[fast];
7        slow = nums[slow];
8        while(fast != slow){
9            fast = nums[fast];
10            fast = nums[fast];
11            slow = nums[slow];
12        }
13
14        fast = 0;
15        while(slow != fast){
16            slow = nums[slow];
17            fast = nums[fast];
18        } 
19        return slow;
20    }
21}