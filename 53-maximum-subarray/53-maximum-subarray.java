/**
[-2,1,-3,4,-1,2,1,-5,4]
[1]
[5,4,-1,7,8]
[1, 2, -4, 3, 4, 5, 9, -9, 8]
[-2,-3,-1]
[-1]
[-1, 2]
[-1, -1, -2]
*/
class Solution {
    
    private void printArray(int[] a, int startIndex, int endIndex){
        
        System.out.print("Array : ");
        for(int i = startIndex ; i <= endIndex ; i++){
             System.out.print( a[i] + " ");
        } System.out.println("");
        
    }
    
    
    private int maxSubArrayUtil(int[] nums, int start , int n) {
        
        if(start == n)
            return 0;
        
        // System.out.println("nums : " + nums + " & start : " + start + " & n : " + n);
        
        int currentSubArraySum = nums[start];
        int maxSubArraySum = nums[start];
        int startIndex = start;
        int endIndex = start;
        for(int i = start + 1 ; i < n ; i++){
            // System.out.println("currentSubArraySum : " + currentSubArraySum 
            //                    + " & startIndex : " + startIndex + " & endIndex : " + endIndex);
            while(currentSubArraySum <= 0 && startIndex <= endIndex){
                currentSubArraySum -= nums[startIndex];
                startIndex++;
            }
            currentSubArraySum += nums[i];
            endIndex = i;
            maxSubArraySum = Math.max(currentSubArraySum, maxSubArraySum);
            
        }
        return maxSubArraySum;
        
    }
    
   
    public int maxSubArray(int[] nums) {
        
        return maxSubArrayUtil( nums, 0  , nums.length);        
    }
}

/**
[-4,-5, -2]
[5, -2, 3, -6, 5]

[-9, 5, -9, -8, 9, 7, -10, 10, 9]
[8, 10, 4, 3, 6, 4, 7]
[-6, -6, 3, -2, 8, -5, 1, 8]
[2, 6, 5, 7, 1, 6, 5]
[-5, -9, 9, 2, -1, 7, -9, 5]
[8, 1, 4, 9, 9, 3, 8, 10 ]
[-5, -6, 10, -2, 5, 4, 5]
[10, 3]
[5, -5, 6, -1, 10, 1, 8, -7, -1, 10 ]
[10, 3, 9, 5, 8, 9, 5, 10]
[0, -2, -5, 9, 8, 6, 4, 5, 4, 7]
*/