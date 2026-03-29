1class Solution {
2    public int findDuplicate(int[] nums) {
3
4        int slow = 0, fast = 0;
5        slow = nums[slow];
6        fast = nums[fast];
7        fast = nums[fast];
8
9        while(slow != fast){
10            slow = nums[slow];
11            fast = nums[fast];
12            fast = nums[fast];
13        }
14
15        slow = 0;
16        while(slow != fast){
17            fast = nums[fast];
18            slow = nums[slow];
19        }
20
21        return slow;
22    }
23}