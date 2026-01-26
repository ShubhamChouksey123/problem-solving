1class Solution {
2
3    private void print(List<int[]> list){
4        for(int i = 0 ; i < list.size() ; i++){
5            System.out.print("[" + list.get(i)[0] + ","+ list.get(i)[1] + "] ");
6        }
7        System.out.println();
8    }
9
10    public int[][] insert(int[][] intervals, int[] newInterval) {
11
12        int n = intervals.length;
13        int index = 0;
14        List<int[]> list = new ArrayList<>();
15        
16        while(index < n && intervals[index][1] < newInterval[0] ){
17            list.add(new int[]{intervals[index][0], intervals[index][1]});
18            index++;
19        }
20
21        int mergedStart = newInterval[0];
22        int mergedEnd = newInterval[1];
23        if(index < n){
24            mergedStart = Math.min(intervals[index][0], mergedStart);
25        }
26        while(index < n && intervals[index][0] <= mergedEnd){
27            mergedEnd = Math.max(intervals[index][1], mergedEnd);
28            index++;
29        }
30        list.add(new int[]{mergedStart, mergedEnd});
31        
32        while(index < n){
33            list.add(new int[]{intervals[index][0], intervals[index][1]});
34            index++;
35        }
36
37        return list.toArray(new int[list.size()][]);
38    }
39}