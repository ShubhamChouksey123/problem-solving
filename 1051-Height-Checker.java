class Solution {
    public int heightChecker(int[] heights) {

        int[] count = new int[100];
        for(int height : heights){
            count[height - 1]++;
        }

        int value = 0, indexAt = 0;
        int totalInvalidIndexes = 0;
        
        for(int i = 0 ; i < 100 ; i++){
            value = i + 1;
            while(count[i] > 0){
                if(heights[indexAt] != value) totalInvalidIndexes++;
                count[i]--;
                indexAt++;
            }
        }
        return totalInvalidIndexes;
    }
}