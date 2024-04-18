class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        // System.out.println("sorted array : " + Arrays.toString(nums));

        int n = nums.length;
        List<List<Integer>> triplets = new ArrayList<>();
        if (n < 3) {
            return triplets;
        }


        int lastFirstValue = Integer.MIN_VALUE;
        for (int first = 0; first < n && first + 1 < n; first++) {

            if (lastFirstValue == nums[first]) {
                continue;
            }

            int second = first + 1;
            int third = n - 1;

            int lastSecondValue = Integer.MIN_VALUE;
            int lastThirdValue = Integer.MIN_VALUE;

            while (second < third) {

                if (lastSecondValue == nums[second]) {
                    second++;
                    continue;
                }
                if (lastThirdValue == nums[third]) {
                    third--;
                    continue;
                }


                int currentSum = nums[first] + nums[second] + nums[third];
                if (currentSum == 0) {
                    lastSecondValue = nums[second];
                    lastThirdValue = nums[third];
                    List<Integer> element = new ArrayList<>();
                    element.add(nums[first]);
                    element.add(nums[second]);
                    element.add(nums[third]);
                    triplets.add(element);
                    second++;
                } else if (currentSum < 0) {
                    second++;
                } else {
                    third--;
                }


            }
            lastFirstValue = nums[first];
        }


        return triplets;
        
    }
}