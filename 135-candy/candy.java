class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candys = new int[n];
        Arrays.fill(candys, 1);

        for(int i = 1 ; i < n ; i++){
            if(ratings[i-1] < ratings[i] && candys[i-1] >= candys[i]){
                candys[i] = candys[i-1] + 1;
            }
        }

        for(int i = n-2 ; i >= 0 ; i--){
            if(ratings[i] > ratings[i+1] && candys[i] <= candys[i+1]){
                candys[i] = candys[i+1] + 1;
            }
        }

        int total =0; 
        for(int candy : candys){
            total += candy; 
        }

        return total;
    }
}