class Solution {
    public int largestAltitude(int[] gain) {
    int maxHeight = 0, height = 0;
        for(int i = 0 ; i < gain.length ; i++){
            height = height + gain[i];
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight;
        
    }
}