class Solution {
    public int majorityElement(int[] nums) {
        int element = 0;
        int n = nums.length;
        int count = 0 ;

        for(int i = 0 ; i < n ; i++){
            if(count == 0){
                element = nums[i]; count++;
            }else if(nums[i] == element){
                count++;
            }else {
                count--;
            }
        }
        // System.out.println("element : " + element);

        return element;
        
    }
}