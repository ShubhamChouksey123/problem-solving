1class Solution {    
2
3    private static final int K = 10;
4
5    public List<String> findRepeatedDnaSequences(String s) {
6
7        int n = s.length();
8        Set<String> seen = new HashSet<>();
9        Set<String> repeated = new HashSet<>();
10
11        for(int i = 0 ; i <= n - K ; i++){
12            String substring = s.substring(i, i + K);
13
14            if(seen.contains(substring) && !repeated.contains(substring)){
15                repeated.add(substring);
16            }
17
18            seen.add(substring);
19        }
20        
21        return new ArrayList<>(repeated);
22    }
23}