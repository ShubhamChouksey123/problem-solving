class Solution {
    
    
     public  int deleteAndEarn(int[] nums) {

        int n = nums.length;
        Map<Integer, Integer> sortedMap = new TreeMap<>();
        for(int i = 0 ; i < n ; i++){
            Integer curSum = sortedMap.get(nums[i]);
            if(curSum == null)
                sortedMap.put(nums[i], nums[i]);
            else
                sortedMap.put(nums[i], curSum + nums[i]);
        }

         int last = 0;
        int lastValue = 0;
        int secondLast = 0;
        int cur = 0;
        for(Map.Entry<Integer, Integer> entry : sortedMap.entrySet()){
            if(lastValue + 1 != entry.getKey()){
                cur = last +  entry.getValue() ;
            }else{
                cur = Math.max(last, entry.getValue() + secondLast);
            }
            secondLast = last;
            last = cur;
            lastValue = entry.getKey();
        }
        return cur;
    }
}

/**
[3,4,2]
[2,2,3,3,3,4]
[3,1]
[1, 2, 3, 4, 44, 5, 6, 4, 5, 3, 2 ]
[1, 2, 3, 4, 2, 3, 4, 5, 2, 3, 5, 2, 2, 3, 4, 5, 4, 1, 3, 5, 6, 7, 888, 2, 2, 3]

*/