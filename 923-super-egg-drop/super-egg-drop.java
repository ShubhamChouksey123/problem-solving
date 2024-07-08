class Solution {
    
    private int superEggDropUtil1(int k, int n) {
        if(n == 1 || n == 0){
            return n;
        }
        if(k == 1){
            return n;
        }
        
        int minMoves = Integer.MAX_VALUE;
        for(int i = 1 ; i <= n ; i++){
            int tmp = 1 + Math.max(superEggDropUtil1(k-1, i-1), superEggDropUtil1(k, n-i)); 
            minMoves = Math.min(minMoves, tmp);
        }
        return minMoves;
    }
    
    private int superEggDropUtil(int k, int n, int[][] minMoves) {
        if(n == 1 || n == 0){
            return n;
        }
        if(k == 1){
            return n;
        }

        if(minMoves[k][n] != -1){
            return minMoves[k][n];
        }
        
        int minMove = 1000000;
        int start = 1, end = n;

        while(start <= end){
            int mid = (start + end)/2;
            int first = superEggDropUtil(k-1, mid-1, minMoves);
            int second = superEggDropUtil(k, n-mid, minMoves);
            int tmp = 1 + Math.max(first, second);

            if(first < second){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }            
            minMove = Math.min(minMove, tmp);
        }

        minMoves[k][n] = minMove;
        return minMoves[k][n];
    }

    public int superEggDrop(int k, int n) {
        // return superEggDropUtil1(k, n);

        int[][] minMoves = new int[k+1][n+1];
        for(int[] inner : minMoves){
            Arrays.fill(inner, -1);
        }

        return superEggDropUtil(k, n, minMoves) ;
    }
}