class Solution {

    public int largestAltitude(int[] gain) {
        int altitude = 0, n = gain.length;

        int highestAltitude = 0;
        for(int i = 0 ; i < n ; i++){
            altitude += gain[i];
            highestAltitude = Math.max(highestAltitude, altitude);
        }

        return highestAltitude;
    }
}