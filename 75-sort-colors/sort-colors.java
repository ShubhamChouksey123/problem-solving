class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;

        int zerCount = 0, oneCount = 0, twoCount = 0;
        for (int num : nums) {
            switch (num) {
                case 1 -> oneCount++;
                case 2 -> twoCount++;
                default -> zerCount++;
            }
        }

        int index = 0;
        while (zerCount-- > 0) {
            nums[index] = 0;
            index++;
        }

        while (oneCount-- > 0) {
            nums[index] = 1;
            index++;
        }

        while (twoCount-- > 0) {
            nums[index] = 2;
            index++;
        }
    }
}