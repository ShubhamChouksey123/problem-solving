class Solution {
    
    private void generateParenthesisUtil(int n, List<String> ans, String s, int openCount, int closeCount) {
        
        if(s.length() == 2*n){
            StringBuilder str = new StringBuilder(s);
            ans.add(str.toString());
            return;
        }

        if(openCount < n){
            generateParenthesisUtil(n, ans, s + "(", openCount + 1, closeCount);
        }

        if(openCount > closeCount){
            generateParenthesisUtil(n, ans, s + ")", openCount, closeCount +1);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        
        List<String> ans = new ArrayList<>();
        generateParenthesisUtil(n, ans, "", 0, 0);

        return ans; 
    }
}