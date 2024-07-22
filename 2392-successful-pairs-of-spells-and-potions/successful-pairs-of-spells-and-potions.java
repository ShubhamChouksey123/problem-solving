class Solution {

    private int getIndex(int spell, int[] potions, long success, int start, int end) {
        
        if(start > end){
            return -1;
        }

        if(start == end){
            if((long)spell * (long)potions[start] >= success){
                return start;
            }
            return -1;
        }

        int mid = (start + end)/2;

        if((long)spell * (long)potions[mid] >= success){
            return getIndex(spell, potions, success, start, mid);
        }
        return getIndex(spell, potions, success, mid +1, end);
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        int n = spells.length, m = potions.length;
        int[] ans = new int[n];
        Arrays.sort(potions);

        for(int i = 0 ; i < n ; i++){
            int index = getIndex(spells[i], potions, success, 0, m-1);
            if(index == -1){
                ans[i] = 0;
            }else{
                ans[i] = m - index;
            }
            
        }
        return ans;
    }
}