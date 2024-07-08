class Solution {
    
    private boolean isPoosibleInTime(int[] piles, int h, int time) {
        
        int count = 0;
        for(int pile : piles){
            count += Math.ceil((double)pile/(double)time);
        }

        if(count <= h){
            return true;
        }
        return false;
    }
    
    public int minEatingSpeedUtil(int[] piles, int h, int start, int end) {
        
        if(start == end){
            return start;
        }
        if(start + 1 == end){
            if(isPoosibleInTime(piles, h, start)){
                return start;
            }
            return start + 1;
        }

        int mid = (start + end)/2;

        boolean isPossible = isPoosibleInTime(piles, h, mid); 

        if(isPossible){
            return minEatingSpeedUtil(piles, h, start, mid); 
        }
        return minEatingSpeedUtil(piles, h, mid + 1, end); 
    }

    public int minEatingSpeed(int[] piles, int h) {
        int maxTime = Integer.MIN_VALUE;
        for(int pile : piles){
            maxTime = Math.max(maxTime, pile);
        }

        return minEatingSpeedUtil(piles, h, 1, maxTime);


    }
}