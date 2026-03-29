1class StockSpanner {
2
3    /**
4        stack containt {price, span}
5     */
6    private Deque<int[]> stack;
7
8    public StockSpanner() {
9        stack = new ArrayDeque<>();
10    }
11    
12    public int next(int price) {
13        
14        int span = 1;
15
16        while(!stack.isEmpty() && stack.peek()[0] <= price){
17            span += stack.pop()[1];
18        }
19
20        stack.push(new int[]{price, span});
21        return span;
22
23    }
24}
25
26/**
27 * Your StockSpanner object will be instantiated and called as such:
28 * StockSpanner obj = new StockSpanner();
29 * int param_1 = obj.next(price);
30 */