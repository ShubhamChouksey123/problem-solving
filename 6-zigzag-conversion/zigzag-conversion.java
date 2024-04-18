class Solution {
    public String convert(String s, int numRows) {
       int n = s.length();

        if (n == 1 || numRows == 1) {
            return s;
        }
        StringBuilder convertedString = new StringBuilder();

        for (int row = 0; row < numRows; row++) {
            StringBuilder nthString = new StringBuilder("");

            for (int topIndex = 0; topIndex < 2*n; topIndex = topIndex + 2 * numRows - 2) {
//                System.out.println("top element " + s.charAt(topIndex) + " with index : " + topIndex + " is a first element");

                int currentIndexLeft = topIndex - row;
                int currentIndexRight = topIndex + row;

                if (currentIndexLeft == currentIndexRight && currentIndexLeft >= 0 && currentIndexLeft < n) {
                    nthString.append(s.charAt(currentIndexLeft));
                    continue;
                }
                if (currentIndexLeft >= 0 && currentIndexLeft < n && row != numRows - 1) {
                    nthString.append(s.charAt(currentIndexLeft));
                }
                if (currentIndexRight >= 0 && currentIndexRight < n) {
                    nthString.append(s.charAt(currentIndexRight));
                }

            }
            System.out.println("for row : " + row + " nthString : " + nthString);
            convertedString.append(nthString);
        }
        return convertedString.toString();
        
    }
}

