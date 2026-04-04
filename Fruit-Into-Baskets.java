1class Solution {
2    public int totalFruit(int[] fruits) {
3
4        int n = fruits.length, len = 0, maxLen = 0, start = 0;
5        Map<Integer, Integer> countOfFruits = new HashMap<>();
6
7        for(int end = 0 ; end < n ; end++){
8            countOfFruits.put(fruits[end], countOfFruits.getOrDefault(fruits[end], 0) + 1);
9           
10            while(countOfFruits.size() > 2){
11                int curCount = countOfFruits.get(fruits[start]);
12                if(curCount == 1){
13                    countOfFruits.remove(fruits[start]);
14                }else{
15                    countOfFruits.put(fruits[start] , --curCount);
16                }
17                start++;
18            }
19            maxLen = Math.max(maxLen, end - start + 1);
20        } 
21        return maxLen;   
22    }
23}
24
25/**
26[1,2,3,2,2]
27[1,2,1,1,2,1,2,1,3,3,1,3,4,1,3,4,5,3,4,4,1,4,5,1,12,13,4,1,3,12,3,15]
28[1,2,1,1,2,1,2,1,3,3,1,3,4]
29[3,3,3,1,2,1,1,2,3,3,4]
30 */