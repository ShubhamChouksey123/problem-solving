1class Solution {
2
3    private String convertToBinary(Integer n){
4        String ans = "";
5        int num = 2; 
6        while (n > 0){
7            ans = (n%2) + ans;
8            n = n / 2;
9        }
10        return ans;
11    }
12
13    public String convertDateToBinary(String date) {
14        String[] components = date.split("-");
15        return convertToBinary(Integer.valueOf(components[0]))
16            + "-"
17            + convertToBinary(Integer.valueOf(components[1]))
18            + "-"
19            + convertToBinary(Integer.valueOf(components[2]))
20        ;
21    }
22}