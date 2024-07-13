class Solution {
    public boolean uniqueOccurrences(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> counts = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            Integer presentCount = counts.get(nums[i]);
            if(presentCount == null){
                counts.put(nums[i], 1);
            }else{
                counts.put(nums[i], 1 + presentCount);
            }
        }

        Set<Integer> st = new HashSet<>();
        for(Map.Entry<Integer, Integer> entry : counts.entrySet()){
            int count = entry.getValue();
            if(st.contains(count)){
                return false;
            }
            st.add(count);
        }

        return true;
    }
}