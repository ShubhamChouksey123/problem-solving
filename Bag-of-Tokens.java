1class Solution {
2    public int bagOfTokensScore(int[] tokens, int power) {
3
4        Arrays.sort(tokens);
5        int n = tokens.length;
6        int score = 0;
7        int maxScore = 0;
8
9        int start = 0, end = n - 1;
10
11        while(start <= end){
12            if(power >= tokens[start]){
13                power -= tokens[start];
14                score++; start++;
15            }
16            else if(score > 0){
17                power += tokens[end];
18                end--; score--;
19            }
20            else break;
21            maxScore = Math.max(maxScore, score);
22        }
23
24        return maxScore; 
25    }
26}