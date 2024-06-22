class Solution {

    private boolean isOdd(int value){
        if(value % 2 != 0){
            return true;
        }
        return false;
    }

    public int numberOfSubarrays(int[] nums, int k) {

        int left = 0, middle=0, n = nums.length, odds = 0, count = 0 ;
        
        for(int end = 0 ; end < n; end++){
            if(isOdd(nums[end])){
                odds++;
            }

            if(odds == k){
                while(!isOdd(nums[middle])){
                    middle++;
                }

                count += (middle -left + 1);
            }

            if(odds > k){
                while(odds > k){
                    if(isOdd(nums[left])){
                        odds--;
                    }
                    left++;
                }
                middle = left;

                while(!isOdd(nums[middle])){
                    middle++;
                }

                count += (middle -left + 1);
            }
            // System.out.println("when left : " + left + " and end : " + end + " the count : "+ count );
        }
        return count;
    }
}