1class Solution {
2
3    private boolean isPalindrome(String s, int start, int end){
4        while(start < end){
5            if(s.charAt(start) != s.charAt(end)) return false;
6            start++;
7            end--;
8        }
9        return true;
10    }
11
12    private void addPalindome(List<List<String>> ans, String s, int n, int start, List<String> cur){
13
14        if(start == n){
15            ans.add(new ArrayList<>(cur));
16            return;
17        }
18
19        for(int end = start ; end < n ; end++){
20            if(!isPalindrome(s, start, end)) continue;
21
22            cur.add(new String(s.substring(start, end + 1)));
23
24            addPalindome(ans, s, n, end + 1, cur);
25
26            cur.remove(cur.size() - 1);
27        }
28    }
29
30    public List<List<String>> partition(String s) {
31
32        int n = s.length();
33        List<List<String>> ans = new ArrayList<>();
34
35        addPalindome(ans, s, n, 0, new ArrayList<>());
36        return ans;
37    }
38}