1class StockSpanner {
2
3    private List<Integer> prices;
4    private List<Integer> spans;
5
6    public StockSpanner() {
7        prices = new ArrayList<>();
8        spans = new ArrayList<>();
9    }
10    
11    public int next(int price) {
12
13        int span = 1;
14        int n = prices.size(); int index = n - 1;
15        
16        while(index >= 0 && prices.get(index) <= price){
17            span = span + spans.get(index);
18            index = index - spans.get(index);
19        }
20
21        prices.add(price);
22        spans.add(span); 
23        return span; 
24    }
25}
26
27/**
28 * Your StockSpanner object will be instantiated and called as such:
29 * StockSpanner obj = new StockSpanner();
30 * int param_1 = obj.next(price);
31 */