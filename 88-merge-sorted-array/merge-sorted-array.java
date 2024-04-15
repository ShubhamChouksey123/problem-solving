class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        List<Integer> mergedArray = new ArrayList<>(n+m);

        int firstPointer = 0 ;
        int secondPointer = 0 ;
        while(firstPointer < m  && secondPointer < n){
        
            // System.out.println("mergedArray : " + mergedArray );
            // System.out.println("firstPointer : " + nums1[firstPointer] + " and secondPointer : " + nums2[secondPointer]);
            if( nums1[firstPointer] <= nums2[secondPointer]){
                mergedArray.add(nums1[firstPointer]);
                firstPointer++;
                continue;
            }
            if(nums1[firstPointer] > nums2[secondPointer]){
                mergedArray.add(nums2[secondPointer]);
                secondPointer++;
                continue;
            }

        }

        if(firstPointer < m){
            for(int i = firstPointer ; i < m ; i++){
                // System.out.println("firstPointer : " + nums1[firstPointer] + " and secondPointer : " + nums2[secondPointer]);
                mergedArray.add(nums1[firstPointer]);
                firstPointer++;
                // System.out.println("first merge mergedArray : " + mergedArray );
            }
        }
        if(secondPointer < n){
            for(int i = secondPointer ; i < n ; i++){
                // System.out.println("firstPointer : " + nums1[firstPointer] + " and secondPointer : " + nums2[secondPointer]);
                mergedArray.add(nums2[secondPointer]);
                secondPointer++;
                // System.out.println("second merge mergedArray : " + mergedArray );
            }
        }

        for(int i = 0 ; i < m+n ; i++){
            nums1[i] = mergedArray.get(i);
        }

    }
}