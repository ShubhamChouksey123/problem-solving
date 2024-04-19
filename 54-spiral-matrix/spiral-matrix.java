class Solution {

    public void spiralOrderUtil(int[][] matrix, int startRow, int endRow, int startColumn, int endColumn, List<Integer> ans) {

System.out.println("start with startRow : " + startRow + " endRow : "+ endRow + " startColumn : " + startColumn + " endColumn" + endColumn);
        for (int j = startColumn; j <= endColumn; j++) {
            System.out.println("row right : " + matrix[startRow][j]);
            ans.add(matrix[startRow][j]);
        }

        for (int i = startRow + 1; i <= endRow; i++) {
            System.out.println("column down : " + matrix[i][endColumn]);
            ans.add(matrix[i][endColumn]);
        }

        for (int j = endColumn - 1; j >= startColumn && startRow != endRow; j--) {
            System.out.println("row left : " + matrix[endRow][j]);
            ans.add(matrix[endRow][j]);
        }

        for (int i = endRow - 1; i >= startRow + 1 && startColumn != endColumn; i--) {
            System.out.println("column up : " + matrix[i][startColumn]);
            ans.add(matrix[i][startColumn]);
        }

    }
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();

        int startRow = 0;
        int endRow = matrix.length - 1;
        int startColumn = 0;
        int endColumn = matrix[0].length - 1;

        while (startRow <= endRow && startColumn <= endColumn) {
            spiralOrderUtil(matrix, startRow, endRow, startColumn, endColumn, ans);
            startRow++;
            startColumn++;
            endRow--;
            endColumn--;

        }
        return ans;
        
    }
}