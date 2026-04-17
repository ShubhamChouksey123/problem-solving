1class Solution {
2    
3    private boolean isValid(int numCourses, List<List<Integer>> adj, Deque<Integer> stack, Set<Integer> inStack, boolean[] added, int course){
4
5        if(inStack.contains(course)){
6            return false;
7        }
8
9        stack.push(course);
10        inStack.add(course);
11
12        for(int nextCourse : adj.get(course)){
13            if(!added[nextCourse] && !isValid(numCourses, adj, stack, inStack, added, nextCourse)){
14                return false;
15            }
16        }
17        added[course] = true;
18        stack.pop();
19        inStack.remove(course);
20        return true;
21    }
22    
23    public boolean canFinish(int numCourses, int[][] prerequisites) {
24        List<List<Integer>> adj = new ArrayList<>(numCourses);
25        for(int i = 0 ; i < numCourses ; i++){
26            adj.add(new ArrayList<>());
27        }
28        
29        for(int i = 0; i < prerequisites.length ; i++){
30            int[] prerequisite = prerequisites[i];
31            adj.get(prerequisite[1]).add(prerequisite[0]);
32        }
33
34        Deque<Integer> stack = new ArrayDeque<>();
35        Set<Integer> inStack = new HashSet<>();
36        boolean[] added = new boolean[numCourses];
37
38        for(int i = 0 ; i < numCourses ; i++){
39            if(!added[i]){
40                if(!isValid(numCourses, adj, stack, inStack, added, i)){
41                    return false;
42                }
43            }
44        }
45
46        
47        return true;
48    }
49}