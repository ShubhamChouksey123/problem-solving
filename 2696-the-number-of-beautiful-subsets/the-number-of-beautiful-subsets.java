class Solution {

    private Integer count = 0;

    private boolean isValidSubSet(List<Integer> elements, int number, Integer k) {

        if (elements == null || elements.isEmpty()) {
            return true;
        }

        for (Integer ele : elements) {
            if (Objects.equals(k, Math.abs(ele - number))) {
                return false;
            }
        }
        return true;
    }

    private void beautifulSubsetUtil(int[] nums, int k, int n, int index, List<Integer> elements) {
        if (index == n) {
            if (!elements.isEmpty()) {
                count++;
            }

            return;
        }

        if (isValidSubSet(elements, nums[index], k)) {
            elements.add(nums[index]);
            beautifulSubsetUtil(nums, k, n, index + 1, elements);
            elements.remove(elements.size() - 1);
        }

        beautifulSubsetUtil(nums, k, n, index + 1, elements);
    }

    public int beautifulSubsets(int[] nums, int k) {
        beautifulSubsetUtil(nums, k, nums.length, 0, new ArrayList<>());
        return count;
    }
}