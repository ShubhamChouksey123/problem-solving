class RandomizedSet {

    private List<Integer> nums;
    private Map<Integer, Integer> valueToIndex;
    private Random rand;

    public RandomizedSet() {
        nums = new ArrayList<>();
        valueToIndex = new HashMap<>();
        rand = new Random(); 
    }
    
    public boolean insert(int val) {
        
        if(valueToIndex.containsKey(val)) return false;

        valueToIndex.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        
        if(!valueToIndex.containsKey(val)) return false;

        int indexAt = valueToIndex.get(val);
        int lastElement = nums.get(nums.size() - 1);

        nums.set(indexAt, lastElement);
        valueToIndex.put(lastElement, indexAt);

        nums.remove(nums.size() - 1);
        valueToIndex.remove(val);
        return true;
    }
    
    public int getRandom() {
        int randIndex = rand.nextInt(nums.size());
        return nums.get(randIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */