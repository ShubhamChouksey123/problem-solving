class Solution {

    private Stack<String> revereStack(Stack<String> st) {

        Stack<String> stReverse = new Stack<>();

        while (!st.isEmpty()) {
            String word = st.pop();
            stReverse.add(word);
        }
        return stReverse;
    }

    public String simplifyPath(String path) {
        
        int n = path.length();

        Stack<String> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = path.charAt(i);
            if (c == '/') {
                continue;
            }
            String word = String.valueOf(c);
            while (i + 1 < n && path.charAt(i + 1) != '/') {
                i++;
                word += path.charAt(i);
            }
            if (Objects.equals(word, "..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else if (Objects.equals(word, ".")) {
            } else
                st.add(word);
        }

        System.out.println("st " + st);
        Stack<String> stReverse = revereStack(st);

        StringBuilder ans = new StringBuilder();
        while (!stReverse.isEmpty()) {
            String word = stReverse.pop();
            ans.append('/');
            ans.append(word);
        }

        if (Objects.equals(ans.toString(), "")) {
            return "/";
        }
        return ans.toString();    
    }
}