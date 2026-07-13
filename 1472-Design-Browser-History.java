class BrowserHistory {

    private List<String> urls;
    private int indexAt;

    public BrowserHistory(String homepage) {
        urls = new ArrayList<>();
        indexAt = 0;
        urls.add(homepage);
    }
    
    public void visit(String url) {
        
        int lastIndex = urls.size() - 1;
        while(lastIndex > indexAt){
            urls.remove(lastIndex);
            lastIndex--;
        }
        urls.add(url);
        indexAt++;
    }
    
    public String back(int steps) {
        indexAt = Math.max(0, indexAt - steps);
        return urls.get(indexAt);   
    }
    
    public String forward(int steps) {
        indexAt = Math.min(urls.size() - 1, indexAt + steps) ;
        return urls.get(indexAt);      
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */