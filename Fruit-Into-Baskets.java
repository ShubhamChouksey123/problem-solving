1class Solution {
2    public int totalFruit(int[] fruits) {
3        
4        int start = 0, maxLen = 0;
5        Map<Integer, Integer> mp = new HashMap<>();
6
7        for(int end = 0 ; end < fruits.length ; end++){
8            int fruit = fruits[end];
9            
10            if(mp.size() == 2 && !mp.containsKey(fruit)){
11                while(mp.size() > 1){
12                    int key = fruits[start];
13                    int count = mp.get(key);  
14                    --count;
15                    if(count == 0){
16                        mp.remove(key);
17                    }else{
18                        mp.put(key, count);
19                    }
20                    start++;
21                }
22                mp.put(fruit, 1);
23            }
24            else{
25                mp.put(fruit , mp.getOrDefault(fruit, 0) + 1);
26            }
27
28            maxLen = Math.max(maxLen, end - start + 1);
29        }
30        return maxLen;
31        
32    }
33}