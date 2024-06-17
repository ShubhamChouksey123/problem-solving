class Solution {
    
    public void permute(int[] nums, int n, List<List<Integer>> ans, boolean[] visited, List<Integer> arr) {

        if(arr.size() == n){
            ans.add(new ArrayList<>(arr));
            return;
        }

        for(int i = 0 ; i  < n ; i++){
            if(visited[i]){
                continue;
            }

            arr.add(nums[i]);
            visited[i] = true;
            permute(nums, n, ans, visited, arr);
            arr.remove(arr.size() -1);
            visited[i] = false;
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        permute(nums, n,  ans, new boolean[n], new ArrayList<>());
        return ans;
    }
}