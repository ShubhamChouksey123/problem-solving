class Solution {
    
   
    public int minSetSize(int[] arr) {
        
        int n = arr.length;
        
        Map<Integer, Integer> count = new HashMap<>();
        
        for(int i = 0 ; i < arr.length ; i++){
            Integer curCount = count.get(arr[i]);
            if(curCount == null){
                curCount = 0;
            }
            count.put(arr[i], ++curCount);
        }
        
        
        LinkedHashMap<Integer, Integer> reverseSortedMap = new LinkedHashMap<>();
        
        count.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
            .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
        
        
        Integer elemetsDeleted = 0;
        Integer elementToBeDeleted = 0; 
        Integer mindeleted = (n%2 == 0) ?  n/2 : n/2 + 1 ;
        
        for(Map.Entry<Integer, Integer> eachEntry : reverseSortedMap.entrySet()){
            // System.out.println("eachEntry Key  : " + eachEntry.getKey() + " & Value  : "  + eachEntry.getValue());
            elemetsDeleted = elemetsDeleted + eachEntry.getValue();
            elementToBeDeleted++;
            if(elemetsDeleted >= mindeleted){
                break;
            }
        }
        return elementToBeDeleted;
        
        
    }
}