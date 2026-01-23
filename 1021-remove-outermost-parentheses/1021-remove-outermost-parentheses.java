class Solution {
    public String removeOuterParentheses(String s) {
        
        int open = 0;
        Deque<Character> dq = new LinkedList<>();
        int i = 0; 
        String ans = "";
        while (i < s.length()){
            if(s.charAt(i) == '('){
                dq.addLast('(');
                open++;
            }
            else if(s.charAt(i) == ')' && open > 0){
                dq.addLast(')');
                open --;
            }
            if(dq.size() > 0 && open == 0){
                dq.removeFirst();
                String tmp = "";
                dq.removeLast();
                while(dq.size() > 0){
                    tmp = tmp + dq.removeFirst();
                }
                ans = ans + tmp;
            }
            i++;
        }
        return ans;
    }
}