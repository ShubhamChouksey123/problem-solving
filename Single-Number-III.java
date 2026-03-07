1class Solution {
2    public int[] singleNumber(int[] nums) {
3        int xor = 0;
4        for(int num: nums){
5            xor ^= num;
6        }    
7
8        int ithDifferentBit = 32;
9        for(int i = 0 ; i < 32 ; i++){
10            if((xor & (1<<i)) != 0){
11                ithDifferentBit = i;
12                break;
13            }
14        }
15
16        int fisrtNumber = 0, secondNumber = 0;
17        for(int num: nums){
18            if((num & ( 1 << ithDifferentBit)) != 0){
19                fisrtNumber ^= num;
20            }
21            else{
22                secondNumber ^= num;
23            }
24        }
25        return new int[]{fisrtNumber, secondNumber}; 
26    }
27}