class Solution {
     public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {

            int startIndex = layer;
            int endIndex = n - 1 - layer;

            for (int i = 0; startIndex + i < endIndex; i++) {

                int temp = matrix[startIndex][startIndex + i];
                matrix[startIndex][startIndex + i] = matrix[endIndex - i][startIndex];
                matrix[endIndex - i][startIndex] = matrix[endIndex][endIndex - i];
                matrix[endIndex][endIndex - i] = matrix[startIndex + i][endIndex];
                matrix[startIndex + i][endIndex] = temp;

            }
        }
    }
}