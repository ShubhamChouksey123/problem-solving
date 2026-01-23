class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        int i = nums1.length - 1;
        int j = nums2.length - 1;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        System.out.println(ans);
        while(i >= 0 || j >= 0){
            if(i-1 >= 0 && nums1[i] == nums1[i-1]){
                i--;
            }
            else if(j-1 >= 0 && nums2[j] == nums2[j-1]){
                j--;
            }
            else if(i >= 0 && j >= 0 && nums1[i] == nums2[j]){
                j--;
                i--;
            }
            else if(i >= 0 && j >= 0 && nums1[i] > nums2[j]){
                ans.get(0).add(nums1[i]);
                i--;
            }
            else if(i >= 0 && j >= 0 && nums1[i] < nums2[j]){
                ans.get(1).add(nums2[j]);
                j--;
            }
            else if(i >=0 ){
                ans.get(0).add(nums1[i]); i--;
            } 
            else if(j >= 0 ){
                ans.get(1).add(nums2[j]);
                j--;
            }
        }
        return ans; 
    }
}