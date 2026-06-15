1class Solution {
2    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
3
4        int n = obstacleGrid.length, m = obstacleGrid[0].length;
5        if(obstacleGrid[0][0] == 1) return 0;
6
7        int[][] countWays = new int[n][m];
8        countWays[0][0] = 1;
9
10        for(int i = 0 ; i < n ; i++){
11            for(int j = 0 ; j < m ; j++){
12                if(obstacleGrid[i][j] == 1) continue;
13                if(i - 1 >= 0){
14                    countWays[i][j] += countWays[i-1][j];
15                }
16                if(j - 1 >= 0){
17                    countWays[i][j] += countWays[i][j-1];
18                }
19            }
20        }
21
22
23        return countWays[n-1][m-1];
24    }
25}