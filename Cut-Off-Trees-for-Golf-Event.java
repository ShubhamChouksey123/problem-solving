1class Solution {
2
3    private static final int[][] DIRECTIONS = new int[][]{
4        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
5    };
6
7    private int countStep(int startX, int startY, int endX, int endY, List<List<Integer>> forest, int n, int m){
8
9        if(startX == endX && startY == endY){
10            return 0;
11        }
12
13        boolean[][] visited = new boolean[n][m];
14        Deque<int[]> queue = new ArrayDeque<>();
15        queue.add(new int[]{startX, startY, 0});
16        visited[startX][startY] = true;
17        int x = 0, y = 0, step = 0;
18
19        while(!queue.isEmpty()){
20            int[] node = queue.pollFirst();
21
22
23            for(int[] direction : DIRECTIONS){
24                x = node[0] + direction[0];
25                y = node[1] + direction[1];
26                step = node[2] + 1;
27
28                if(x == endX && y == endY){
29                    return step;
30                }
31                
32
33                if(x >= 0 && x < n && y >= 0 && y < m && forest.get(x).get(y) != 0 && !visited[x][y]){
34                    visited[x][y] = true;
35                    queue.offerLast(new int[]{x, y, step});
36                }
37            }
38        }
39        return -1;
40
41    }
42    public int cutOffTree(List<List<Integer>> forest) {
43
44        int n = forest.size(), m = forest.get(0).size();
45        List<int[]> orderedForets = new ArrayList<>();
46
47        for(int i = 0 ; i < n ; i++){
48            for(int j = 0 ; j < m ; j++){
49                if(forest.get(i).get(j) > 1)
50                    orderedForets.add(new int[]{forest.get(i).get(j), i, j});
51            }
52        }
53        
54        Collections.sort(orderedForets, (a, b) -> Integer.compare(a[0], b[0]));
55
56
57        int startX = 0; 
58        int startY = 0;
59        int endX = 0, endY = 0, totalStep = 0;
60
61        for(int i = 0 ; i < orderedForets.size(); i++){
62            endX = orderedForets.get(i)[1];
63            endY = orderedForets.get(i)[2];
64
65            int step = countStep(startX, startY, endX, endY, forest, n, m);
66            
67            if(step == -1){
68                return -1;
69            }
70            totalStep += step;
71            startX = endX; startY = endY;
72        }
73
74        return totalStep;
75    }
76}