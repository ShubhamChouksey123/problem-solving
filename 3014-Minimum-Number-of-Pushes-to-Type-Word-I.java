class Solution {

    public int minimumPushes(String word) {

        int totalButtonPress = 0;
        for(int index = 0 ; index < word.length() ; index++){
            totalButtonPress = ((index / 8) + 1) + totalButtonPress;
        }
        return totalButtonPress;
    }   
}