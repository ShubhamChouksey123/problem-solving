1class StockSpanner {
2
3    private List<Integer> list;
4
5    public StockSpanner() {
6        list = new ArrayList<>();
7    }
8    
9    public int next(int price) {
10
11        int span = 1;
12        int n = list.size(); int index = n-1;
13        while(index >= 0 && list.get(index) <= price){
14            span++; index--;
15        }
16
17        list.add(price); 
18        return span; 
19    }
20}
21
22/**
23 * Your StockSpanner object will be instantiated and called as such:
24 * StockSpanner obj = new StockSpanner();
25 * int param_1 = obj.next(price);
26 */