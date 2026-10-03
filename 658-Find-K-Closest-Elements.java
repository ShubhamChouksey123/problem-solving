class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int n = arr.length;
        int start = 0, end = n - 1;

        while(end - start + 1 > k){
            if( Math.abs(arr[start] - x) <= Math.abs(arr[end] - x) ) {
                end--;
            }
            else {
                start++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = start ; i <= end ; i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}