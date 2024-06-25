class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int maxCandy = 0;
        for(int candy : candies){
            maxCandy = Math.max(maxCandy, candy);
        }

        int n = candies.length;
        List<Boolean> ans = new ArrayList<>();
        
        System.out.println("ans : " + ans);

        for(int i = 0 ; i < n ; i++){
            if(candies[i] + extraCandies >= maxCandy){
                ans.add(true);
            }else{
                ans.add(false);
            }
        }
        
        return ans;
    }
}