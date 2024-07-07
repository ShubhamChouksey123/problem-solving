class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {

        int empty = numBottles, total = numBottles, newBootles = 0;

        while(empty >= numExchange){
            newBootles = empty/numExchange;
            total += newBootles;
            empty = empty % numExchange;
            empty = empty + newBootles;
        }
        return total;
    }
}