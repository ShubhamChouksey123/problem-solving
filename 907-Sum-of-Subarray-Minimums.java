class Solution {
    private final int MOD = 1_000_000_000 + 7; 

    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        long totalSum = 0;
        int[] right = new int[n];
        int[] left = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0 ; i < n ; i++){
            while(!stack.isEmpty() && arr[stack.peekLast()] > arr[i]){
                int top = stack.pollLast();
                right[top] = i - top; 
            }
            stack.offerLast(i);   
        }
        stack.clear();
        

        for(int i = n - 1 ; i >= 0 ; i--){
            while(!stack.isEmpty() && arr[stack.peekLast()] >= arr[i]){
                int top = stack.pollLast();
                left[top] = top - i; 
            }
            stack.offerLast(i);   
        }

        for(int i = 0 ; i < n ; i++){
            if(right[i] == -1) right[i] = n - i;
        }
        for(int i = 0 ; i < n ; i++){
            if(left[i] == -1) left[i] = i + 1;
        }

        
        for(int i = 0 ; i < n ; i++){
            long count = (long)(left[i] * right[i]) % MOD;
            long contributon = (long)(arr[i] * count) % MOD;
            totalSum = (totalSum + contributon) % MOD;
        }

        return (int)totalSum;

    }
}