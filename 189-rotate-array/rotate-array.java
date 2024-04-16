class Solution {
    public void swapArrayElement(int[] nums, int index1, int index2) {

        System.out.println("swapping element : " + nums[index1] + " & " + nums[index2]);

        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;


    }

    public void reverseArray(int[] nums, int index1, int length) {

        for (int i = 0; i <= length/2 - 1; i++) {
            swapArrayElement(nums, index1 + i, length -1-i + index1);
        }
    }

    public int getSimplifiedK(int n, int k) {

        if (n <= 1) {
            return 0;
        }

        if (k == 0 || k < n) {
            return k;
        }

        return k % n;

    }

    public void rotate(int[] nums, int k) {

        k = getSimplifiedK(nums.length, k);

        reverseArray(nums, 0, nums.length );
        System.out.println("first nums : " + Arrays.toString(nums));

        reverseArray(nums, 0, k );
        System.out.println("second nums : " + Arrays.toString(nums));

        reverseArray(nums, k, nums.length - k);
        System.out.println("nums : " + Arrays.toString(nums));
    }

}