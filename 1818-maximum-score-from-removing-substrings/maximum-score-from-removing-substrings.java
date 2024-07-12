class Solution {

    private int x;
    private int y;

    private int maximumGainBA(String s, int n, int start, int end) {
        // System.out.println("start : " + start + " and end : " + end);
        if(start < 0 || start >= n){
            return 0;
        }
        if(end < 0 || end >= n){
            return 0;
        }
        if(end - start < 1){
            return 0;
        }
        
        Stack<Character> st = new Stack<>();
        int score = 0;

        for(int i = start ; i <= end ; i++){
            char c = s.charAt(i);
            // System.out.println("c : " + c + ", st : " + st + " and score : " + score);
            if(!st.isEmpty()){
                if(Objects.equals(st.peek(), 'b') && c == 'a'){
                    score += y;
                    st.pop();
                    continue;
                }
            }
            st.push(c);
        }

        // System.out.println("st : " + st);

        char[] rem = new char[st.size()];
        int size = st.size();
        int index = size - 1;
        while(!st.isEmpty()){
            rem[index] = st.pop(); index--;
        }
        st = new Stack<>();

        for(int i = 0 ; i < size ; i++){
            char c = rem[i];
            // System.out.println("c : " + c + ", st : " + st + " and score : " + score);
            if(!st.isEmpty()){
                if(Objects.equals(st.peek(), 'a') && c == 'b'){
                    score += x;
                    st.pop();
                    continue;
                }
            }
            st.push(c);
        }

        return score;
    }

    private int maximumGainAB(String s, int n, int start, int end) {

        if(start < 0 || start >= n){
            return 0;
        }
        if(end < 0 || end >= n){
            return 0;
        }
        if(end - start < 1){
            return 0;
        }
        
        Stack<Character> st = new Stack<>();
        int score = 0;

        for(int i = start ; i <= end ; i++){
            char c = s.charAt(i);
            if(!st.isEmpty()){
                if(Objects.equals(st.peek(), 'a') && c == 'b'){
                    score += x;
                    st.pop();
                    continue;
                }
            }
            st.push(c);
        }


        char[] rem = new char[st.size()];
        int size = st.size();
        int index = size - 1;
        while(!st.isEmpty()){
            rem[index] = st.pop(); index--;
        }
        st = new Stack<>();

        for(int i = 0 ; i < size ; i++){
            char c = rem[i];
            // System.out.println("c : " + c + ", st : " + st + " and score : " + score);
            if(!st.isEmpty()){
                if(Objects.equals(st.peek(), 'b') && c == 'a'){
                    score += y;
                    st.pop();
                    continue;
                }
            }
            st.push(c);
        }

        return score;
    }

    public int maximumGain(String s, int x, int y) {
        int n = s.length();this.x = x; this.y = y;
        int start = 0, scoreBA = 0, scoreAB = 0;
        s = s + "c";
        
        for(int i = 0; i <= n ; i++){
            char c = s.charAt(i);
            if(c != 'a' && c != 'b'){
                int currentScore = maximumGainBA(s, n, start, i - 1);
                scoreBA += currentScore; 
                start = i+1;
            }
        }

        start = 0; 

        for(int i = 0; i <= n ; i++){
            char c = s.charAt(i);
            if(c != 'a' && c != 'b'){
                int currentScore = maximumGainAB(s, n, start, i - 1);
                scoreAB += currentScore; 
                start = i+1;
            }
        }
        // System.out.println("scoreAB : " + scoreAB + " and scoreBA : " + scoreBA);

        return Math.max(scoreAB, scoreBA);
    }
}


/**

"cdbcbbaaabab"
4
5
"aabbaaxybbaabb"
5
4
"aabbaaxybbaabbaabababcababababbbbabbabbbba"
5
4
"abababcaaabbbabaaabababaabbbaaabbaabaab"
5
4
"cccacacbabcbababbacababacccbcaabccab"
4
5
 */