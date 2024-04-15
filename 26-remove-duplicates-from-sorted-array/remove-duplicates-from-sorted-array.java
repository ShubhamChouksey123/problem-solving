class Solution {

    public void swapArrayElement(int[] nums, int index1, int index2) {

        int n = nums.length;

        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;

    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        if (nums.length == 1)
            return 1;

        int n = nums.length;
        int max = nums[0];

        int index = 1;

        int countDistinct = 1;
        while (index < n) {

            if (nums[index] > max) {
                max = nums[index];
                index++;
                countDistinct++;
                continue;

            }
            if (nums[index] <= max) {
                int j = index + 1;
                for (j = index + 1; j < n; j++) {
                    if (nums[j] > max) {
                        max = nums[j];
                        swapArrayElement(nums, index, j);
                        countDistinct++;
                        index++;
                        break;
                    }
                }
                if (j == n) {
                    break;
                }
            }
        }

        System.out.println("nums : " + Arrays.toString(nums));
        System.out.println("countDistinct : " + countDistinct);
        return countDistinct;

    }
}