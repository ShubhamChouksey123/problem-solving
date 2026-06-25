1class Solution {
2    public int canCompleteCircuit(int[] gas, int[] cost) {
3
4        int n = gas.length;
5        int prevGas = 0;
6        int length = 0;
7        int index = 0;
8
9        for(int i = 0 ; i < 2 * n ; i++){   
10            index = i;
11            if(i >= n){
12                index = i % n;
13            }
14
15            if(cost[index] <= prevGas + gas[index]){
16                length++;
17                prevGas = prevGas + gas[index] - cost[index];
18            }
19            else{
20                length = 0; prevGas = 0;
21            }
22            if(length == n) return (index + 1) % n;
23        }
24
25        return -1;
26    }
27}