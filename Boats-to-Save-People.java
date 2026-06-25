1class Solution {
2    public int numRescueBoats(int[] people, int limit) {
3
4        int n = people.length;
5        Arrays.sort(people);
6
7        int start = 0, end = n - 1;
8        int boats = 0;
9
10        while(start < end){
11            if(people[start] + people[end] <= limit){
12                boats++; start++; end--;
13            }
14            else{
15                boats++; end--;
16            }
17        } 
18        if(start == end) boats++;
19        return boats;
20    }
21}