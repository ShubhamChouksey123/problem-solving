class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        
        int[][] array2D = new int[m][n];
        
        if(original.length != m*n){
            return new int[0][0];
        }
        
        int i = 0 ; int j = 0;
        
        for(int index = 0 ; index < original.length ; index++){
            array2D[i][j] = original[index];
            j++;
            if(j%n == 0){
                j = 0 ; i++;
            }
        }
        return array2D;
        
    }
}

/**
[1,2,3,4]
2
2
[1, 2, 3]
1
3
[1, 2]
1
1
*/