1class Solution {
2
3    private int indexAtAns;
4
5    private boolean performDfs(List<List<Integer>> adj, Deque<Integer> stack, boolean[] added, int[] ans, Set<Integer> stackElements, int course){
6        stack.push(course);
7        stackElements.add(course);
8
9        for(Integer neighbour : adj.get(course)){
10            if(stackElements.contains(neighbour)){
11                return false;
12            }
13            if(!added[neighbour]){
14                if(!performDfs(adj, stack, added, ans, stackElements, neighbour)){
15                    return false;
16                }
17            }
18        }
19
20        stack.pop(); 
21        stackElements.remove(course);    
22        ans[indexAtAns--] = course;
23        added[course] = true;
24        return true;
25    }
26
27    /**
28        DFS based topological sort
29     */
30    public int[] findOrder(int numCourses, int[][] prerequisites) {
31        List<List<Integer>> adj = new ArrayList<>(numCourses);
32        for(int i = 0 ; i < numCourses ; i++){
33            adj.add(new ArrayList<>());
34        }
35
36        int u= 0, v = 0;
37        for(int i = 0 ; i < prerequisites.length ; i++){
38            v = prerequisites[i][0];
39            u = prerequisites[i][1];
40            adj.get(u).add(v);
41        }
42
43        Deque<Integer> stack = new ArrayDeque<>();
44        boolean[] added = new boolean[numCourses];
45        int[] ans = new int[numCourses];
46        indexAtAns = numCourses - 1;
47        Set<Integer> stackElements = new HashSet<>();
48
49        for(int i = 0 ; i < numCourses ; i++){
50            if(!added[i]){
51                if(!performDfs(adj, stack, added, ans, stackElements, i)){
52                    return new int[0];
53                }
54            }
55        }
56
57        return ans;
58    }
59}