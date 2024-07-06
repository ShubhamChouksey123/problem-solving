class Solution {
    public int passThePillow(int n, int time) {
        
        int osc = 2 * (n- 1);
        time = time % osc;

        if(time <= osc/2){
            return time+1;
        }

        time = osc - time;
        return 1 + time;

    }
}