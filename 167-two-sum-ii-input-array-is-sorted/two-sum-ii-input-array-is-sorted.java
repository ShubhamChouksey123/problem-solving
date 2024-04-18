class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int[] pairs = new int[2];
        if(n == 1){
            return pairs;
        }


        int start = 0;
        int end = n-1;

        while(start < end){
            int currentSum = numbers[start] + numbers[end];
            if(currentSum == target){
                pairs[0] = start + 1;
                pairs[1] = end + 1;
                break;
            }
            else if(currentSum < target){
                start++;
            }else{
                end--;
            }

        }
        
        return pairs;
    }
}