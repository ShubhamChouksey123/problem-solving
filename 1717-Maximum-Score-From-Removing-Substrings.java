class Solution {

    public int maximumGain(String s, int x, int y) {

        int n = s.length();
        Deque<Character> stack = new ArrayDeque<>();
        int ans = 0;
        String first = (x >= y) ? "ab" : "ba";
        int maxAmount = Math.max(x, y);
        String second = (x >= y) ? "ba" : "ab"; 
        int minAmount = Math.min(x, y);
        

        for(int i = 0 ; i < n ; i++){
            char c = s.charAt(i);
            if(!stack.isEmpty() && c == first.charAt(1) && stack.peekLast() == first.charAt(0) ){
                stack.pollLast(); ans += maxAmount;
            }            
            else {
                stack.offerLast(c);
            }
        }
        
        Deque<Character> remaining = new ArrayDeque<>();
        while(!stack.isEmpty()){
            char c = stack.pollFirst();

            if(!remaining.isEmpty() && c == second.charAt(1) && remaining.peekLast() == second.charAt(0) ){
                remaining.pollLast(); ans += minAmount;
            }
            else {
                remaining.offerLast(c);
            }
        }

        return ans;
    }
}