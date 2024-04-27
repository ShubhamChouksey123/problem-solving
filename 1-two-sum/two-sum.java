class Solution {
    
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> valueIndexMap = new HashMap<>();

        int[] ans = new int[2];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (valueIndexMap.containsKey(target - num)) {
                ans[0] = valueIndexMap.get(target - num);
                ans[1] = i;
                break;
            }

            valueIndexMap.put(num, i);
        }
        return ans;
    }
}