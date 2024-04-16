class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] citationCount = new int[n + 1];


        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= citations[i] && j <= n; j++) {
                int earlierCount = citationCount[j];
                citationCount[j] = earlierCount + 1;
            }
        }

        int hIndex = 0;
        for (int i = 0; i <= n; i++) {
            if (citationCount[i] >= i) {
                hIndex = i;
            }
        }
        // System.out.println("citationCount : " + Arrays.toString(citationCount));
        // System.out.println("hIndex : " + hIndex);
        return hIndex;
        
    }
}