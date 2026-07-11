class StockSpanner {

    /**
        Stack containing {value, index} in decreasing orders of value
     */
    private Deque<int[]> stack;

    /** 
        span of value at index
    */
    private List<Integer> spanAt;

    private int indexAt;

    public StockSpanner() {
        this.stack = new ArrayDeque<>();
        this.spanAt = new ArrayList<>();
        this.indexAt = 0;
    }
    
    public int next(int price) {
        
        int span = 1;
        while(!stack.isEmpty() && stack.peekLast()[0] <= price ){
            int topElementIndex = stack.pollLast()[1];
            span += spanAt.get(topElementIndex);
        }

        spanAt.add(span) ;
        stack.offerLast(new int[]{price, indexAt});
        indexAt ++;
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */