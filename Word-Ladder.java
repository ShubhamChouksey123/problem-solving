1class Solution {
2
3    private boolean areNeighbours(String a, String b){
4        if(a.length() != b.length()) return false;
5
6        int countDifferences = 0;
7        for(int i = 0 ; i < a.length() ; i++){
8            if(a.charAt(i) != b.charAt(i)){
9                countDifferences++;
10            }
11        }
12        return countDifferences == 1;
13    }
14
15    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
16        
17        int n = wordList.size();
18        boolean[] visited = new boolean[n];
19        List<List<Integer>> adj = new ArrayList<>();
20        for(int i = 0; i < n ; i++){
21            adj.add(new ArrayList<>());
22        }
23        
24        for(int i = 0 ; i < n ; i++){
25            for(int j = 0 ; j < n ; j++){
26                if(i != j && areNeighbours(wordList.get(i), wordList.get(j))){
27                    adj.get(i).add(j);
28                }
29            }
30        }
31
32        Deque<int[]> queue = new ArrayDeque<>();
33        int step = 2;
34
35        for(int i = 0 ; i < n ; i++){    
36            if(areNeighbours(beginWord, wordList.get(i))){
37                visited[i] = true;
38                queue.offerLast(new int[]{i, 2});
39            }
40        }
41
42        while(!queue.isEmpty()){
43            int[] node = queue.pollFirst();
44            step = node[1];
45            if(endWord.equals(wordList.get(node[0]))){
46                return step;
47            }
48
49            for(int neighbour : adj.get(node[0])){
50                if(!visited[neighbour]){
51                    visited[neighbour] = true;
52                    queue.offerLast(new int[]{neighbour, step + 1});
53                }
54            }
55        }
56        return 0;
57
58    }
59}