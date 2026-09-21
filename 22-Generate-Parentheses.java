class Solution {

    public void generateParenthesis(int n, List<String> ans, int openCount, int closeCount, StringBuilder builder) {
        
        if(closeCount == n){
            ans.add(builder.toString());
            return;
        }

        if(openCount < n){
            builder.append('(');
            generateParenthesis(n, ans, openCount + 1, closeCount, builder);   
            builder.deleteCharAt(builder.length() - 1);
        }
        if(closeCount < openCount){
            builder.append(')');
            generateParenthesis(n, ans, openCount, closeCount + 1, builder);   
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateParenthesis(n, ans, 0, 0, new StringBuilder());   
        return ans;
    }
        
}