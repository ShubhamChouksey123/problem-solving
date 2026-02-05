1class Solution {
2    
3    public void spiralOrder(int[][] matrix, int startX, int startY, int lenX, int lenY, List<Integer> ans) {
4
5        if(lenX <= 0 || lenY <= 0){
6            return;
7        }
8        
9        for(int j = 0 ; j < lenY  && lenY > 0; j++){
10            ans.add(matrix[startX][j + startY]);
11        }
12
13        for(int i = 1 ; i < lenX  && lenX > 1; i++){
14            ans.add(matrix[startX + i][startY + lenY - 1]);
15        }
16
17        for(int j = lenY - 2 ; j >= 0 && lenX > 1 ; j--){
18            ans.add(matrix[startX + lenX - 1][j + startY]);
19        }
20
21        for(int i = lenX - 2 ; i > 0 && lenY > 1; i--){
22            ans.add(matrix[startX + i][startY]);
23        }
24
25        spiralOrder(matrix, startX + 1, startY + 1, lenX - 2, lenY - 2, ans);
26    }
27
28    public List<Integer> spiralOrder(int[][] matrix) {
29
30        int startX = 0, startY = 0, lenX = matrix.length, lenY = matrix[0].length; 
31        List<Integer> ans = new ArrayList<>();
32        spiralOrder(matrix, startX, startY, lenX, lenY, ans);
33
34        return ans;
35    }
36}