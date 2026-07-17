class SnapshotArray {

    private int snapShotId;
    private Map<Integer, List<List<Integer>>> indexToSnapshots;

    /**
        changes contains [index, newValue]
     */
    private Map<Integer, Integer> changes;

    public SnapshotArray(int length) {
        indexToSnapshots = new HashMap<>();
        changes = new HashMap<>();
        snapShotId = 0;
    }
    
    public void set(int index, int val) {
        changes.put(index, val);
    }
    
    public int snap() {

        for(Map.Entry<Integer, Integer> entry : changes.entrySet()){
            int index = entry.getKey();
            int newValue = entry.getValue();

            List<List<Integer>> list = indexToSnapshots.getOrDefault(index, new ArrayList<>());
            List<Integer> element = List.of(snapShotId, newValue);
            list.add(element);
            indexToSnapshots.put(index, list);
        }
        
        
        changes.clear();
        snapShotId++;
        return snapShotId - 1;   
    }
    
    public int get(int index, int snap_id) {

        if(!indexToSnapshots.containsKey(index)) return 0;

        
        List<List<Integer>> list = indexToSnapshots.get(index);
        
        int start = 0, end = list.size() - 1;
        int ans = -1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(list.get(mid).get(0) <= snap_id){
                ans = mid; 
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        if(ans == -1) return 0;
        return list.get(ans).get(1);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */