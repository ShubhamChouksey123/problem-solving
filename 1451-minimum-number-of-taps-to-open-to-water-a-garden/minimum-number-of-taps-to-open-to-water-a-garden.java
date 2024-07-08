class Solution {
    public int minTaps(int n, int[] ranges) {

        int[] minTaps = new int[n+1];
        Arrays.fill(minTaps, n+2);

        minTaps[0] = 0;
        for(int i = 0 ; i <= n ; i++){
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);

            for(int j = start ; j <= end ; j++){
                minTaps[j] = Math.min(minTaps[j], minTaps[start] + 1); 
            }
        }

        if(minTaps[n] == n+2){
            return -1;
        }
        return minTaps[n];
    }
}