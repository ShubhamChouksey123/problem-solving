class Solution {

    private int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public long gcdSum(int[] nums) {
        
        int n = nums.length;
        int[] prefixGcd = new int[n];

        int maxUntilNow = 0;
        for(int i = 0 ; i < n ; i++){
            maxUntilNow = Math.max(maxUntilNow, nums[i]);
            prefixGcd[i] = gcd(nums[i], maxUntilNow);
        }

        Arrays.sort(prefixGcd);

        int largedUnpairedIndex = n - 1;
        long sumOfGcds = 0;
        for(int smallestUnpairedIndex = 0 ; smallestUnpairedIndex <  n / 2 ; smallestUnpairedIndex ++){
            largedUnpairedIndex = n - smallestUnpairedIndex - 1;
            sumOfGcds += gcd(prefixGcd[smallestUnpairedIndex], prefixGcd[largedUnpairedIndex]);
        }
        return sumOfGcds;
    }
}