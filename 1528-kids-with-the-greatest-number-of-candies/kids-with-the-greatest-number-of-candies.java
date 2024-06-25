class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int maxCandy = 0;
        for(int candy : candies){
            maxCandy = Math.max(maxCandy, candy);
        }

        int n = candies.length;
        List<Boolean> ans = Arrays.asList(new Boolean[n]);

        
        for(int i = 0 ; i < n ; i++){
            if(candies[i] + extraCandies >= maxCandy){
                ans.set(i, true);
            }else{
                ans.set(i, false);
            }
        }
        
        return ans;
    }
}