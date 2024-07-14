class StockSpanner {

    private List<Integer> prices;
    private List<Integer> spans;
    
    public StockSpanner() {
        prices = new ArrayList<>();
        spans = new ArrayList<>();
    }
    
    public int next(int price) {
        int span = 0;

        int poisiton = prices.size() - 1;
        while(poisiton >= 0 && prices.get(poisiton) <= price){
            span += spans.get(poisiton);
            poisiton = poisiton - spans.get(poisiton);  
        }

        span++;
        prices.add(price);
        spans.add(span);
        return span;

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */