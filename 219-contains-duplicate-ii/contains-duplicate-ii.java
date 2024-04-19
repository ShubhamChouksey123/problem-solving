class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        if (n == 1)
            return false;

        Set<Integer> occurredElements = new HashSet<>();

        for (int i = 0; i <= k && i < n; i++) {
            if (occurredElements.contains(nums[i])) {
                return true;
            }
            occurredElements.add(nums[i]);
        }


        for (int i = k + 1; i < n; i++) {
            occurredElements.remove(nums[i - k - 1]);
            if (occurredElements.contains(nums[i])) {
                return true;
            }
            occurredElements.add(nums[i]);
        }

        return false;
    }
}