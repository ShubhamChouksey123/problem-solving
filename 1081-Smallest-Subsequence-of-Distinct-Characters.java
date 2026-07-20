class Solution {

    private static final int TOTAL_CHARS = 26; 

    public String smallestSubsequence(String s) {

        int n = s.length();
        char[] chars = s.toCharArray();

        int[] frequencyRemaining = new int[TOTAL_CHARS];
        boolean[] inStack = new boolean[TOTAL_CHARS];

        char c = 'a';
        for(int i = 0 ; i < n ; i++){
            c = chars[i];
            frequencyRemaining[c - 'a']++;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0 ; i < n ; i++){
            c = chars[i];
            frequencyRemaining[c - 'a']--;

            if(inStack[c - 'a']) continue;

            while(!stack.isEmpty() && stack.peekLast() > c && frequencyRemaining[stack.peekLast() - 'a'] > 0){
                char removedChar = stack.pollLast();
                inStack[removedChar - 'a'] = false;

            }

            inStack[c - 'a'] = true;
            stack.offerLast(c);
        }
        StringBuilder builder = new StringBuilder();
        while( !stack.isEmpty() ){
            builder.append(stack.pollFirst());
        }

        return builder.toString();
        
    }

    
}