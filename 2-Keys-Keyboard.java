1class Solution {
2    
3    private int minStepsUtil(int n, int len, int copiedStringLen) {
4        
5        if(len == n){
6            return 0;
7        }
8
9        int copyOperation = 5000;
10        if(len > copiedStringLen){
11            copyOperation = 1 + minStepsUtil(n, len, len);
12        }
13       
14        int pasteOperation = 5000;
15        if(copiedStringLen >= 1 && n - len >= copiedStringLen){
16            pasteOperation = 1 + minStepsUtil(n, len + copiedStringLen, copiedStringLen);
17        }
18
19        int optimalOperation = Math.min(copyOperation, pasteOperation); 
20        return optimalOperation;
21    }
22    
23    public int minSteps(int n) {
24        
25        return minStepsUtil(n, 1, 0); 
26    }
27}