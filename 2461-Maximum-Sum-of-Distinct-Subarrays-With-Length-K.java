class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        
        int n = nums.length;
        Map<Integer, Integer> countOfInt = new HashMap<>();
        long maxSum = 0; long sum = 0;
        
        for(int i = 0 ; i < k ; i++){
            int num = nums[i];
            sum += num;
            countOfInt.put(num, countOfInt.getOrDefault(num, 0) + 1);
            if(countOfInt.size() == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        
        for(int i = k ; i < n ; i++){
            int addingNum = nums[i];
            countOfInt.put(addingNum, countOfInt.getOrDefault(addingNum, 0) + 1);
            int levingNum = nums[i - k];
            int leavingCount = countOfInt.getOrDefault(levingNum, 0);
            leavingCount--;
            if(leavingCount == 0){
                countOfInt.remove(levingNum);
            }
            else {
                countOfInt.put(levingNum, leavingCount);
            }
            sum = sum + addingNum - levingNum;
            if(countOfInt.size() == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}