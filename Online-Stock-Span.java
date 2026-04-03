1class StockSpanner {
2
3    private Deque<List<Integer>> stockSpanStack;
4
5    public StockSpanner() {
6
7        /**
8            stockSpan stack containing list of {value of stock, span}
9         */
10        stockSpanStack = new ArrayDeque<>();
11    }
12    
13    public int next(int price) {
14        int span = 1;
15
16        while(!stockSpanStack.isEmpty() && stockSpanStack.peek().get(0) <= price){
17            List<Integer> topStockSpan = stockSpanStack.poll();
18            span += topStockSpan.get(1);
19        }
20
21        stockSpanStack.push(List.of(price, span));
22        return span;
23        
24    }
25}
26
27/**
28 * Your StockSpanner object will be instantiated and called as such:
29 * StockSpanner obj = new StockSpanner();
30 * int param_1 = obj.next(price);
31 */