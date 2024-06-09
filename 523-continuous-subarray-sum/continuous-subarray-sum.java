class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] % k;
            sum += nums[i];
            sum = sum % k;

            if (sum == 0 && i != 0) {
                return true;
            }

            Integer indexOfPrevious = mp.get(sum);
            if (indexOfPrevious != null) {
                if (i - indexOfPrevious > 1) {
                    return true;
                }
            } else {
                mp.put(sum, i);
            }
        }

        return false;
    }
}