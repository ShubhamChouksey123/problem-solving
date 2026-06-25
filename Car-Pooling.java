1class Solution {
2    public boolean carPooling(int[][] trips, int capacity) {
3        
4        int[] timeline = new int[1001];
5
6        int from = 0, to = 0, people = 0;
7        for(int i = 0 ; i < trips.length ; i++){
8            from = trips[i][1];
9            to = trips[i][2];
10            people = trips[i][0];
11
12            timeline[from] += people;
13            timeline[to] -= people;
14        }
15
16        int peopleInCar = 0;
17
18        for(int change : timeline){
19            peopleInCar += change;
20            if(peopleInCar > capacity) return false;
21        }
22        return true;
23
24
25    }
26}