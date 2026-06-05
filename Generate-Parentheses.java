1class Solution {
2    
3    private void generateParenthesis(int n, List<String> ans, String curr, int openCount, int closedCount) {
4        
5        if(openCount == n && closedCount == n){
6            ans.add(new String(curr));
7            return;
8        }
9
10        if(openCount < n){
11            generateParenthesis(n, ans, curr + '(', openCount + 1, closedCount);
12        }
13        if(closedCount < n && openCount > closedCount){
14            generateParenthesis(n, ans, curr + ')', openCount, closedCount + 1);
15        }
16    }
17    
18    public List<String> generateParenthesis(int n) {
19        
20        List<String> ans = new ArrayList<>(); 
21        generateParenthesis(n, ans, "", 0, 0) ;
22        return ans;
23    }
24}