class Solution {
    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        int start = 0;
        int index = 0;

        while (index < n) {

            int number = nums[index];
            int count = 1;
            while (index + 1 < n && nums[index + 1] == number) {
                count++;
                index++;
            }

            if (count == 1) {
                nums[start] = number;
                start++;
            } else if (count >= 2) {
                nums[start] = number;
                nums[start + 1] = number;
                start = start + 2;
            }
//            start = start + Math.min(count, 2);
            index++;
        }

        // System.out.println("nums : " + Arrays.toString(nums));

        return start;
        
    }
}