class Solution {

    private int find(List<Integer> list, int num, int totalItems){

        int n = list.size();
        if(list.size() <= 1) return -1;

        int start = 0, end = n - 1;

        int mid = 0;
        while(start <= end){
            mid = start + (end - start)/2;
            if(list.get(mid) == num) {
                break;
            }
            else if(list.get(mid) < num){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        int index = mid;
        int a = Integer.MAX_VALUE;
        if(index == 0){
            a = list.get(0) + totalItems - list.get(n - 1);
        }
        else {
            a = list.get(index) - list.get(index - 1);
        }


        int b = Integer.MAX_VALUE;
        if(index == n - 1){
            b = list.get(0) + totalItems - list.get(n - 1);
        }
        else {
            b = list.get(index + 1) - list.get(index);
        }

        return Math.min(a, b);
    }

    public List<Integer> solveQueries(int[] nums, int[] queries) {
        
        int n = nums.length;
        Map<Integer, List<Integer>> numberToIndexList = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            if(numberToIndexList.get(nums[i]) == null){
                List<Integer> ls = new ArrayList<>();
                ls.add(i);
                numberToIndexList.put(nums[i], ls);
            }
            else {
                numberToIndexList.get(nums[i]).add(i);
            }
        }
        
        
        List<Integer> ans = new ArrayList<>(queries.length);

        for(int i = 0 ; i < queries.length ; i++){
            ans.add(find(numberToIndexList.get(nums[queries[i]]), queries[i], n)); 
        }

        return ans;
    }
}























