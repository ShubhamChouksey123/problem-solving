1class Solution {
2    public int bagOfTokensScore(int[] tokens, int power) {
3
4        Arrays.sort(tokens);
5        int n = tokens.length, score = 0;
6        int start = 0 , end = n-1;
7
8        while(start <= end){
9            if(tokens[start] <= power){
10                score++;
11                power -= tokens[start];
12                start++;
13            }
14            else if(score > 0 && start < end){
15                power += tokens[end];
16                score--;
17                end--;
18            }else{
19                break;
20            }
21        }
22        return score;
23    }
24}