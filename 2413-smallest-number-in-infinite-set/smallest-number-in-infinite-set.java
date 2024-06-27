class SmallestInfiniteSet {

    Set<Integer> st;
    public SmallestInfiniteSet() {
        st = new TreeSet<>();
        for(int i = 1 ; i <= 1000 ; i++){
            st.add(i);
        }
    }
    
    public int popSmallest() {
        if(!st.isEmpty()){
            int first = st.iterator().next();
            st.remove(first);
            return first;
        }
        return 1;
    }
    
    public void addBack(int num) {
        if(!st.contains(num)){
            st.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */