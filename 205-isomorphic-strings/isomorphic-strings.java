class Solution {
    private int getSize(String s) {
        Set<Character> st = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            st.add(c);
        }
        return st.size();
    }


    public boolean isIsomorphic(String s, String t) {

        int n = s.length();
        int m = t.length();

        if (n != m) {
            return false;
        }

        Map<Character, Character> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Character sChar = s.charAt(i);
            Character tChar = t.charAt(i);

            Character foundChar = mp.putIfAbsent(sChar, tChar);

            if (foundChar != null && !Objects.equals(foundChar, tChar)) {
                return false;
            }
        }
        
        int st1Size = getSize(s);
        int st2Size = getSize(t);

        if(st1Size != st2Size)
            return false;

        return true;
    }
}