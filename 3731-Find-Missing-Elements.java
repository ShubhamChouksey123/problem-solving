class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        int n = nums.length;
        int minValue = nums[0], maxValue = nums[0]; 
        for(int i = 0 ; i < n ; i++){
            minValue = Math.min(minValue, nums[i]);
            maxValue = Math.max(maxValue, nums[i]);
        }

        int size = maxValue - minValue + 1;
        boolean[] exists = new boolean[size]; 
        for(int num : nums){
            exists[num - minValue] = true;
        }

        List<Integer> missingInNums = new ArrayList<>();
        for(int i = 0 ; i < size ; i++){
            if(!exists[i]){
                missingInNums.add(i + minValue);
            }
        }
        return missingInNums;
    }
}