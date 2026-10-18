class Solution {
    public int longestValidParentheses(String s) {
        
        int n = s.length(), maxLength = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerLast(-1);


        for(int i = 0 ; i < n ; i++){
            
            if(s.charAt(i) == '('){
                stack.offerLast(i);
            }
            else if(s.charAt(i) == ')'){
                stack.pollLast();
                if(!stack.isEmpty()){
                    int len = i - stack.peekLast();
                    maxLength = Math.max(maxLength, len);
                }
            }
            if(stack.isEmpty()){
                stack.offerLast(i);
            }
        }
        return maxLength;
    }
}