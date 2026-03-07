1class Solution {
2
3    private boolean isPalindrom(String s, int start, int end){
4        System.out.println("start : " + start + ", end : " + end);
5        while(start < end){
6            if(s.charAt(start) != s.charAt(end)){
7                return false;
8            }
9            start++; end--;
10        }
11        return true;
12    }
13    private void partitionUtils(String s, int start, List<String> cur, List<List<String>> result) {
14
15        if(start == s.length()){
16            result.add(new ArrayList<>(cur));
17            return;
18        }
19
20        for(int end = start ; end < s.length() ; end++){
21            if(isPalindrom(s, start, end)){
22                String substring = s.substring(start, end + 1);
23                cur.add(substring);
24                partitionUtils(s, end + 1, cur, result);
25                cur.remove(cur.size() - 1);    
26            }   
27        }
28    }
29    
30    public List<List<String>> partition(String s) {
31        int n = s.length();
32        List<List<String>> result = new ArrayList<>();
33        partitionUtils(s, 0, new ArrayList<>(), result);
34
35        return result;     
36    }
37}