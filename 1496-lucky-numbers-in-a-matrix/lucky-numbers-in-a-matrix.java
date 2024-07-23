class Solution {
    
    private int getMinIndexInRow(int[][] matrix, int row) {
        int minIndex = 0;
        for(int j = 1 ; j < matrix[0].length ; j++){
            if(matrix[row][j] < matrix[row][minIndex]){
                minIndex = j;
            }
        }
        return minIndex;
    }

    private boolean isMaxElementInColumn(int[][] matrix, int column, int value) {
        for(int i = 0 ; i < matrix.length ; i++){
            if(matrix[i][column] > value){
                return false;
            }
        }
        return true;
    }
    
    public List<Integer> luckyNumbers (int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < m ; i++){
            int minIndexColumn = getMinIndexInRow(matrix, i);
            if(isMaxElementInColumn(matrix, minIndexColumn, matrix[i][minIndexColumn])){
                ans.add(matrix[i][minIndexColumn]);
            }
        }
        return ans;
    }
}