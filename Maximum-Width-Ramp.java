1class Solution {
2    public int maxWidthRamp(int[] nums) {
3        
4        int n = nums.length;
5
6        /**
7        Stack containg decreasing elemets indexes
8         */
9        Deque<Integer> decreasingElements = new ArrayDeque<>();
10        for(int i = 0 ; i < n ; i++){
11            if(decreasingElements.isEmpty() || nums[decreasingElements.peek()] > nums[i]){
12                decreasingElements.push(i);
13            }
14        }
15
16        int maxRamp = 0, ramp = 0;
17
18        for(int j = n - 1 ; j > 0 ; j--){
19            while(!decreasingElements.isEmpty() && nums[decreasingElements.peek()] <= nums[j]){
20                ramp = j - decreasingElements.pop();
21                maxRamp = Math.max(maxRamp, ramp);
22            }
23        }
24        return maxRamp;
25    }
26}