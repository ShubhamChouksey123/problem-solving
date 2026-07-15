class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> ans = new ArrayList<>();
        for(int startDigit = 1 ; startDigit <= 9 ; startDigit++){
            int num = startDigit;
            int lastDigit = num;
            while(num <= high){
                if(num >= low && num <= high){
                    ans.add(num);
                }
                if(lastDigit == 9) break;
                lastDigit++;
                num = (num * 10) + lastDigit;
                
            }
        }
        Collections.sort(ans);
        return ans;
    }
}