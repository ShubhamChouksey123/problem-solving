class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int n = profits.length;
        int[][] profitCapitalArray = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            profitCapitalArray[i][0] = profits[i];
            profitCapitalArray[i][1] = capital[i];
        }

        Arrays.sort(profitCapitalArray, 
            (a, b) -> Integer.compare(a[1], b[1])
        );

        Queue<Integer> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
        );
        int indexOnArray = 0;
        while(indexOnArray < n && profitCapitalArray[indexOnArray][1] <= w){
            maxHeap.add(profitCapitalArray[indexOnArray][0]);
            indexOnArray++;
        }


        int maximimumCapital = w;
        while(k-- > 0 && !maxHeap.isEmpty()){

            maximimumCapital += maxHeap.poll();

            while(indexOnArray < n && profitCapitalArray[indexOnArray][1] <= maximimumCapital){
                maxHeap.add(profitCapitalArray[indexOnArray][0]);   
                indexOnArray++;
            }
        }

        return maximimumCapital;  
    }
}