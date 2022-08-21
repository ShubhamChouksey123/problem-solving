class Solution {
      public static int minCost(String colors, int[] neededTime) {

        int n = neededTime.length;
        int sumValue = neededTime[0];
        int groupMax = neededTime[0];
        int count = 1;

        int totalTime = 0;

        for(int i = 1 ; i < n ; i++){
            if(colors.charAt(i) == colors.charAt(i-1)){
                sumValue += neededTime[i];
                groupMax = Math.max(groupMax, neededTime[i]);
                count++;
            }else{
                totalTime += (sumValue - groupMax);
                sumValue = neededTime[i];
                groupMax = neededTime[i];
                count = 1;
            }

        }


        if(count > 1){
            totalTime += (sumValue - groupMax);
        }

        return totalTime;

    }
   
    
}

/**
"abaac"
[1,2,3,4,5]
"abc"
[1, 2, 3]
"aabaa"
[1,2,3,4,1]
"aaabbbabbbb"
[3,5,10,7,5,3,5,5,4,8,1]


*/