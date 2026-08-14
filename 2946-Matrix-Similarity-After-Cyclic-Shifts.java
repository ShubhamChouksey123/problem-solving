class Solution {

    private boolean areSimilarRow(int[] row, int k) {

        int n = row.length;
        int[] rotatedRow = new int[n];

        for(int i = 0 ; i < n ; i++){
            rotatedRow[(i + k) % n] = row[i];
        }        
        
        for(int i = 0 ; i < n ; i++){
            if(rotatedRow[i] != row[i]) return false;
        }
        return true;
    }

    public boolean areSimilar(int[][] mat, int k) {

        int n = mat.length , m = mat[0].length;
        k = k % m ;

        for(int i = 0 ; i < n ; i++){
            if(!areSimilarRow(mat[i], k)) return false;
        }

        return true;
    }
}