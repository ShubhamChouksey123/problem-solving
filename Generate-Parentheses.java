1class Solution {
2
3    public void generateParenthesisutil(int n, List<String> result, int openCount, int closeCount, StringBuilder stringBuilder) {
4
5        if(openCount == n && closeCount == n){
6            String ans = stringBuilder.toString();
7            result.add(ans); return;
8        }
9
10        if(openCount + closeCount > 2*n){
11            return;
12        }
13
14        if(closeCount == n){
15            return;
16        }
17
18
19        if(openCount < n){
20            stringBuilder.append('(');
21            generateParenthesisutil(n, result, openCount + 1, closeCount, stringBuilder);
22            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
23        }
24
25        if(closeCount < n && openCount > closeCount){
26            stringBuilder.append(')');
27            generateParenthesisutil(n, result, openCount, closeCount + 1, stringBuilder);
28            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
29        }
30        
31    }
32
33    public List<String> generateParenthesis(int n) {
34        List<String> result = new ArrayList<>();
35        generateParenthesisutil(n, result, 0, 0, new StringBuilder());
36        return result;
37    }
38}