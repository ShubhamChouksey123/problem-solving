1class StockSpanner {
2
3    /**
4        Stack containing {price, span}
5     */
6    private Deque<int[]> pricesAndSpans;
7
8    public StockSpanner() {
9        pricesAndSpans = new ArrayDeque<>();
10    }
11    
12    public int next(int price) {
13
14        int span = 1;
15        
16        while(!pricesAndSpans.isEmpty() && pricesAndSpans.peek()[0] <= price){
17            int[] priceAndSpan = pricesAndSpans.pop();
18            span += priceAndSpan[1];
19        }
20
21        pricesAndSpans.push(new int[]{price, span});
22        return span; 
23    }
24}
25
26/**
27 * Your StockSpanner object will be instantiated and called as such:
28 * StockSpanner obj = new StockSpanner();
29 * int param_1 = obj.next(price);
30 */