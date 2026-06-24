1class Solution {
2    public boolean canReach(int[] arr, int start) {
3
4        int n = arr.length;
5        boolean[] visited = new boolean[n];
6
7        Deque<Integer> queue = new ArrayDeque<>();
8        queue.offerLast(start);
9        visited[start] = true;
10
11        while(!queue.isEmpty()){
12
13            int index = queue.pollFirst();
14            if(arr[index] == 0) return true;
15
16            if(index - arr[index] >= 0 && !visited[index - arr[index]]) {
17                queue.offerLast(index - arr[index]);
18                visited[index - arr[index]] = true;
19            }
20
21            if( index + arr[index] < n && !visited[index + arr[index]] ){
22                queue.offerLast(index + arr[index]);
23                visited[index + arr[index]] = true;
24            } 
25        }
26        return false;
27    }
28}