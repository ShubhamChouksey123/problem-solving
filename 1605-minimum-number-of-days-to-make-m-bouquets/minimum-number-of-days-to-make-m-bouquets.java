class Solution {

    private boolean canComplete(int day, int[] bloomDay, int m, int k){

        Integer totalBouqets = 0;
        Integer adjacent = 0;
        for(int i = 0 ; i < bloomDay.length ; i++){
            if(bloomDay[i] <= day){
                adjacent++;
                if(adjacent == k){
                    totalBouqets++;
                    adjacent = 0;
                }
            }else{
                adjacent = 0;
            }
        }
        if(totalBouqets >= m){
            return true;
        }
        return false;

    }

    private int findMinDay(int[] bloomDay, int m, int k, int start , int end){

        // System.out.println("start : " + start + " and end : " + end);
        if(start == end){
            return start;
        }

        if(start + 1 == end){
            if(canComplete(start, bloomDay, m, k)){
                return start;
            }
            return end;
        }

        int mid = (start + end)/2;

        if(canComplete(mid, bloomDay, m, k)){
            return findMinDay(bloomDay, m, k, start , mid);
        }

        return findMinDay(bloomDay, m, k, mid +1 , end);

    }


    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        int minPossible = Integer.MAX_VALUE;
        int maxPossible = Integer.MIN_VALUE;
        for(int num :  bloomDay){
            minPossible = Math.min(num, minPossible);
            maxPossible = Math.max(num, maxPossible);
        }


        if(m*k > n || !canComplete(maxPossible, bloomDay, m, k)){
            return -1;
        }
        int minDays = findMinDay(bloomDay, m, k, minPossible, maxPossible); 
        return minDays;
    }
}

/**

[1,10,3,10,2]
3
1
[1,10,3,10,2]
3
2
[7,7,7,7,12,7,7]
2
3
[100]
1
1
[1000000000,1000000000]
1
1

 */