1class Solution {
2    public int[] findArray(int[] pref) {
3        
4
5        int n = pref.length;
6        int[] ans = new int[n];
7        ans[0] = pref[0];
8
9        for(int i = 1 ; i < n ; i++){
10            ans[i] = pref[i] ^ pref[i-1];
11        }
12        return ans;
13    }
14}