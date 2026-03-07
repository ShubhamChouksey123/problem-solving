1class Solution {
2    public void generateParenthesisUtil(int n, int openCount, int closeCount, StringBuilder builder, List<String> result) {
3        if(openCount + closeCount == 2*n){
4            String s = builder.toString();
5            result.add(s); 
6            return;
7        }
8
9        if(openCount < n){
10            builder.append('(');
11            generateParenthesisUtil(n, openCount + 1, closeCount, builder, result);
12            builder.deleteCharAt(builder.length() - 1);
13        }
14        if(openCount > closeCount){
15            builder.append(')');
16            generateParenthesisUtil(n, openCount, closeCount + 1, builder, result);
17            builder.deleteCharAt(builder.length() - 1);
18        }
19    }
20    
21    public List<String> generateParenthesis(int n) {
22        List<String> result = new ArrayList<>();
23        generateParenthesisUtil(n, 0, 0, new StringBuilder(), result);
24        return result;
25    }
26}