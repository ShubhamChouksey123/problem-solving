class Solution {

    private int findLargestIndexInRange(int[] nums, int n, int val, int start, int end) {

        int mid = 0;

        int ans = -1;
        while(start <= end){
            mid = start + (end - start)/2;
            if(nums[mid] <= val){
                ans = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return ans;
    }

    private int findSmallestIndexInRange(int[] nums, int n, int val, int start, int end) {

        int mid = 0;

        int ans = -1;
        while(start <= end){
            mid = start + (end - start)/2;
            if(nums[mid] >= val){
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {

        int n = nums.length;
        Arrays.sort(nums);
        long totalCount = 0;

        for(int i = 0 ; i < n ; i++){
            int x = nums[i];
            int largestIndex = findLargestIndexInRange(nums, n, upper - x, i + 1, n - 1) ;
            int smallestIndex = findSmallestIndexInRange(nums, n, lower - x, i + 1, n - 1) ;
            
            long count = largestIndex - smallestIndex + 1;
            if(smallestIndex != -1 && largestIndex != -1) totalCount += count;
        }
        return totalCount;
    }
}