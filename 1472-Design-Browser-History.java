class BrowserHistory {

    private int idTotal;
    private Map<Integer, String> idToUrl;
    private Deque<Integer> backwardQ;
    private Deque<Integer> forwardQ;


    public BrowserHistory(String homepage) {
        idTotal = 0;
        idToUrl = new HashMap<>();
        backwardQ = new ArrayDeque<>();
        forwardQ = new ArrayDeque<>();

        visit(homepage);
    }
    
    public void visit(String url) {
        idToUrl.put(idTotal, url);
        backwardQ.offerLast(idTotal++);
        forwardQ.clear();
    }
    
    public String back(int steps) {
        
        int time = 0;
        while(!backwardQ.isEmpty() && time < steps){
            int top = backwardQ.pollLast();
            forwardQ.offerFirst(top);
            time++;
        }

        Integer id = null;
        if(!backwardQ.isEmpty()){
            id = backwardQ.peekLast();
        }
        else if(!forwardQ.isEmpty()){
            backwardQ.offerLast(forwardQ.pollFirst());
            id = backwardQ.peekLast();
        }
        if(id != null){
            return idToUrl.get(id);
        }
        return null;
        
    }
    
    public String forward(int steps) {

        int time = 0;
        while(!forwardQ.isEmpty() && time < steps){
            int top = forwardQ.pollFirst();
            backwardQ.offerLast(top);
            time++;
        }
        Integer id = null;
        if(!backwardQ.isEmpty()){
            id = backwardQ.peekLast();
        }
        if(id != null){
            return idToUrl.get(id);
        }
        return null;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */