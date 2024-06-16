class Solution {

    private boolean isValidTime(String time){

        int hour = Integer.valueOf(time.substring(0, 2));
        if(hour > 23){
            return false;
        }
        int min = Integer.valueOf(time.substring(2, 4));
        if(min > 59){
            return false;
        }
        return true;

    }

    private String getMaxTime(String time1, String time2){

        if(time1 == null){
            return time2;
        }

        int hour1 = Integer.valueOf(time1.substring(0, 2));
        int hour2 = Integer.valueOf(time2.substring(0, 2)); 
        if(hour1 != hour2){
            return (hour1 < hour2 ? time2 : time1);
        }

        int min1 = Integer.valueOf(time1.substring(2, 4));
        int min2 = Integer.valueOf(time2.substring(2, 4)); 

        return (min1 < min2 ? time2 : time1);
    }

    public String largestTimeFromDigits(int[] arr) {

        String maxTime = null;
        
        for(int i = 0 ; i < 4 ; i++){
            for(int j = 0 ; j < 4 ; j++){
                if(i == j){
                    continue;
                }
                for(int k = 0 ; k < 4 ; k++){
                    if(k == i || k == j){
                        continue;
                    }
                    int l = 6 - (i + j + k);
                    if(l == i || l == j || l == k){
                        continue;
                    }

                    String time = String.valueOf(arr[i]) + String.valueOf(arr[j]) + String.valueOf(arr[k]) + String.valueOf(arr[l]);
                    if(!isValidTime(time)){
                        continue;
                    }

                    maxTime = getMaxTime(maxTime, time);
                }
            }
        }

        if(maxTime == null){
            return "";
        }
        return maxTime.substring(0, 2) + ":" + maxTime.substring(2, 4) ;
    }
}