class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        Set<Integer> st1 = new HashSet<>();
        Set<Integer> st2 = new HashSet<>();

        for(int num: nums1){
            st1.add(num);
        }
        for(int num: nums2){
            st2.add(num);
        }
        
        List<Integer> answer0 = new ArrayList<>();
        st1.forEach(
            (num) -> {
                if(!st2.contains(num)){
                    answer0.add(num);
                }
            }
        );

        List<Integer> answer1 = new ArrayList<>();
        st2.forEach(
            (num) -> {
                if(!st1.contains(num)){
                    answer1.add(num);
                }
            }
        );

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(answer0);
        answer.add(answer1);
        return answer;
    }
}