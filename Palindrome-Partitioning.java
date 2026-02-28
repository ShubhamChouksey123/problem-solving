1class Solution {
2    
3    private boolean isPalindrome(String s, int startIndex, int endIndex){
4        for(int i = 0 ; i <= (endIndex - startIndex)/ 2 ; i++){
5            if(s.charAt(startIndex + i) != s.charAt(endIndex-i)){
6                return false;
7            }
8        }
9        return true;
10    }
11
12    private void partitionUtil(List<List<String>> result, String s, int n, int startIndex, List<String> cur) {
13
14        if(startIndex == n){
15            result.add(new ArrayList<>(cur));
16            return;
17        }
18        
19        for(int endIndex = startIndex ; endIndex < n ; endIndex++){
20            if(isPalindrome(s, startIndex, endIndex)){
21                cur.add(s.substring(startIndex, endIndex + 1));
22                partitionUtil(result, s, n, endIndex + 1, cur);
23                cur.remove(cur.size() - 1);
24            }
25        }
26
27    }
28
29    public List<List<String>> partition(String s) {
30        List<List<String>> result = new ArrayList<>();
31        partitionUtil(result, s, s.length(), 0, new ArrayList<>());
32
33        return result; 
34    }
35}