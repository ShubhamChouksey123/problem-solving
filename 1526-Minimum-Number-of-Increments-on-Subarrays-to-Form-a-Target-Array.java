class Solution {
    public int minNumberOperations(int[] target) {

        int n = target.length;
        int localMax = 0, result = 0;
        result = target[0];
        localMax = target[0];

        
        for(int i = 1 ; i < n ; i++){
            if(target[i] > localMax){
                result += (target[i] - localMax);
            }
            localMax = target[i];
        }
        return result;
    }
}