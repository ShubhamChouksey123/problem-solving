class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> intervals = new ArrayList<>();
        if (n == 0) {
            return intervals;
        }


        int start = 0;
        int end = 1;
        int currentNumber ;

        while (start < n) {
            currentNumber = nums[start];
            while (end < n && nums[end] == currentNumber + 1) {
                currentNumber = nums[end];
                end++;
            }


            String str = null;
            if (start + 1 == end) {
                str = String.valueOf(nums[start]);
            } else {
                str = nums[start] + "->" + nums[end - 1];
            }
            intervals.add(str);
            start = end;

            end++;

        }
        return intervals;
    }
}