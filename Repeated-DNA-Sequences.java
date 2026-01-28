1class Solution {
2    public List<String> findRepeatedDnaSequences(String s) {
3
4        int n = s.length();
5        List<String> result = new ArrayList<>();
6        if(n <= 10)
7            return result;
8        
9        Set<String> set = new HashSet<>();
10        Set<String> resultSet = new HashSet<>();
11        StringBuilder stringBuilder = new StringBuilder();
12        for(int i = 0 ; i < 10; i++){
13            stringBuilder.append(s.charAt(i));
14        }
15        set.add(stringBuilder.toString());
16        
17        for(int i = 10 ; i < n ; i++){
18            stringBuilder.append(s.charAt(i));;
19            stringBuilder.delete(0, 1);
20            if(set.contains(stringBuilder.toString()) && !resultSet.contains(stringBuilder.toString()) ){
21                result.add(stringBuilder.toString());
22                resultSet.add(stringBuilder.toString());
23            }else{
24                set.add(stringBuilder.toString());
25            }
26        }
27        return result;
28        
29    }
30}