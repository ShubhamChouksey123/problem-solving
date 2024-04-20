class RandomizedSet {


    Set<Integer> st = new HashSet<>();

    public RandomizedSet() {
        st = new HashSet<>();
    }
    
    public boolean insert(int val) {
        if(st.contains(val)){
            return false;
        }
        return st.add(val);
    }
    
    public boolean remove(int val) {
        if(st.contains(val)){
            return st.remove(val);
        }
        return false;
    }
    
    public int getRandom() {

        List<Integer> list = new ArrayList<>(st);
        Random rand = new Random();
        int no = rand.nextInt();
        if (no < 0) {
            no = no * -1;
        }

        no = no % list.size();

        return list.get(no);
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */