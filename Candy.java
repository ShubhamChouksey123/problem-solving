1class Solution {
2    public int candy(int[] ratings) {
3
4        int n = ratings.length;
5        int[] candies = new int[n];
6        Arrays.fill(candies, 1);
7
8        for(int i = 1 ; i < n ; i++){
9            if(ratings[i-1] < ratings[i] && candies[i-1] >= candies[i]){
10                candies[i] = candies[i-1] + 1;
11            }
12        }
13
14        for(int i = n - 1 ; i > 0 ; i--){
15            if(ratings[i-1] > ratings[i] && candies[i-1] <= candies[i]){
16                candies[i-1] = candies[i] + 1;
17            }
18        }
19
20        int totalCandy = 0;
21        for(int candy : candies){
22            totalCandy += candy;
23        }
24        return totalCandy;
25    }
26}