1class Solution {
2    public boolean carPooling(int[][] trips, int capacity) {
3
4        int[] pickupLocation = new int[1001]; 
5        int[] dropLocation = new int[1001]; 
6
7        for(int i = 0 ; i < trips.length ; i++){
8            int people = trips[i][0], from = trips[i][1], to = trips[i][2];
9            pickupLocation[from] += people;
10            dropLocation[to] += people;
11
12        }
13
14        int peopleInCar = 0;
15
16        for(int i = 0 ; i <= 1000 ; i++){
17            peopleInCar -= dropLocation[i];
18
19            if(peopleInCar + pickupLocation[i] > capacity) return false;
20
21            peopleInCar += pickupLocation[i];
22        }
23        return true;
24    }
25}