class Solution {
    public int findCenter(int[][] edges) {
        int[] first = edges[0];
        int[] second = edges[1];

        int ans = first[0];

        if(ans == second[0] || ans == second[1]){
            return ans;
        }
        return first[1];
    }
}