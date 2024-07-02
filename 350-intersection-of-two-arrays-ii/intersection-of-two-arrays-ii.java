class Solution {

    private void prepareMap(int[] nums, Map<Integer, Integer> counts){

        for(int num : nums){
            Integer count = counts.get(num);
            if(count == null){
                counts.put(num, 1);
            }else{
                counts.put(num, count +1);
            }
        }
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> counts1 = new HashMap<>();
        Map<Integer, Integer> counts2 = new HashMap<>();

        prepareMap(nums1, counts1);
        prepareMap(nums2, counts2);

        List<Integer> commonNumbers = new ArrayList<>();

        counts1.forEach(
            (k, v) -> {
                Integer count = counts2.get(k);
                if(count != null && count > 0){
                    
                    int times = Math.min(count, v);
                    while(times-- > 0){
                        commonNumbers.add(k);
                    }

                }
            }
        );


        int[] ans = new int[commonNumbers.size()];
        int index = 0;
        for(Integer commonNumber : commonNumbers){
            ans[index] = commonNumber; index++;
        }
        return ans;
    }
}