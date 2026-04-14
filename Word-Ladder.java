1class Solution {
2
3    private int N;
4    private int wordLength;
5    
6    private boolean isAdjacent(String a , String b){
7        int diff = 0;
8        for(int i = 0 ; i < wordLength ; i++){
9            if(a.charAt(i) != b.charAt(i)){
10                diff++;
11            }
12            if(diff > 1) return false;
13        }
14        return (diff == 1);
15    }
16
17    private void createAdjList(List<String> wordList, boolean[][] adj){
18
19        for(int i = 0 ; i < N ; i++){
20            for(int j = 0 ; j < N ; j++){
21                if(i != j && isAdjacent(wordList.get(i), wordList.get(j))){
22                    adj[i][j] = true;
23                }
24            }
25        }
26    }
27
28    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
29
30        N = wordList.size();
31        wordLength = beginWord.length();
32        boolean[] visited = new boolean[N];
33        boolean[][] adj = new boolean[N][N];
34        createAdjList(wordList, adj);
35
36        Deque<int[]> queue = new ArrayDeque<>();
37        int time = 0;
38
39        for(int i = 0 ; i < N ; i++){
40            if(!wordList.get(i).equals(beginWord) && isAdjacent(wordList.get(i), beginWord)){
41                visited[i] = true; time = 2;
42                queue.offerLast(new int[]{i, 2});
43            }
44        }
45
46        while(!queue.isEmpty()){
47            int[] node = queue.pollFirst();
48            int nodeIndex = node[0]; 
49            time = node[1];
50            if(wordList.get(nodeIndex).equals(endWord)){
51                return time;
52            }
53
54            for(int i = 0 ; i < N ; i++){
55                if(i != nodeIndex && adj[nodeIndex][i] && !visited[i]){
56                    visited[i] = true;
57                    queue.offerLast(new int[]{i, time + 1});
58                }
59            }
60        }
61        return 0;
62        
63    }
64}