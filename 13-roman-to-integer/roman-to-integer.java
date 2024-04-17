class Solution {

    /**
     * 'I', 'V', 'X', 'L', 'C', 'D', 'M'
     */
    static Map<Character, Integer> mp = Map.ofEntries(
            Map.entry('I', 1),
            Map.entry('V', 5),
            Map.entry('X', 10),
            Map.entry('L', 50),
            Map.entry('C', 100),
            Map.entry('D', 500),
            Map.entry('M', 1000)
    );
    public int romanToInt(String s) {
        int n = s.length();
        int sum = 0;
        int previousValue = 0;
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int currentValue = mp.get(c);

            if (currentValue < previousValue) {
                currentValue = -currentValue;
            }
            sum += currentValue;
            previousValue = currentValue;
        }
        System.out.println("sum : " + sum);
        return sum;
        
    }
}