class Solution {
    public int minPatches(int[] nums, int n) {
        
        int length = nums.length;

        long searchNumber = 1;
        int count = 0;
        int index = 0 ;
        

        while(searchNumber <= n){
            
            if(index < length && nums[index] <= searchNumber){
                searchNumber += nums[index];
                index++;
            }else {
                searchNumber += searchNumber;
                count++;
            }
        }
        return count;
    }
}