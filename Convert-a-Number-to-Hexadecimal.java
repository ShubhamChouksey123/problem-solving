1class Solution {
2    public String toHex(int num) {
3        if (num == 0)
4            return "0";
5
6        String hex = "0123456789abcdef";
7        String result = "";
8
9        while (num != 0) {
10            int rem = num & 15;           
11            result = hex.charAt(rem) + result;
12            num = num >>> 4;             
13        }
14
15        return result;
16    }
17}