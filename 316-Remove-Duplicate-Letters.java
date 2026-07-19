class Solution {

    private static final int TOTAL_CHARS = 26;

    public String removeDuplicateLetters(String s) {

        int n = s.length();
        
        boolean[] inStack = new boolean[TOTAL_CHARS];
        int[] remainingCount = new int[TOTAL_CHARS];

        char[] chars = s.toCharArray();
        for(int i = 0 ; i < n ; i++){
            char c = chars[i];
            remainingCount[c - 'a']++;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0 ; i < n ; i++){
            char c = chars[i];
            remainingCount[c - 'a']--;

            if(inStack[c - 'a']) continue;

            while(!stack.isEmpty() && stack.peekLast() > c && remainingCount[stack.peekLast() - 'a'] > 0 ){
                char removedChar = stack.pollLast();
                inStack[removedChar - 'a'] = false; 
            }

            stack.offerLast(c);
            inStack[c - 'a'] = true; 
            
        }

        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()){
            char removedChar = stack.pollFirst();
            builder.append(removedChar);
        }
        return builder.toString();

    }
}