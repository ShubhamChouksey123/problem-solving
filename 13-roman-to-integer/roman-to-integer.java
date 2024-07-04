class Solution {
    private static final Map<Character, Integer> values = new HashMap<>(
        Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000)
    );
    
    public int romanToInt(String s) {
        
        int n = s.length();
        int sum = values.get(s.charAt(0));
        int previousValue = sum;

        for(int i = 1; i < n ; i++){
            char c = s.charAt(i);
            int value = values.get(c);
            sum += value;
            if(previousValue < value){
                sum -= (previousValue * 2);
            }
            previousValue = value;
        }
        return sum;
    }
}