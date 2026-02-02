1class Solution {
2    public int[] twoSum(int[] numbers, int target) {
3
4        int start = 0, end = numbers.length - 1 ;
5
6        while(start < end){
7            
8            int sum = numbers[start] + numbers[end];
9            if( sum == target ){
10                return new int[]{start + 1, end + 1};
11            }
12            else if( sum > target ){
13                end--;
14            }
15            else if( sum < target ){
16                start++;
17            }
18        }
19        return new int[2];
20    }
21}