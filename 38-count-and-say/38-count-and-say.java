class Solution {
    
    
    private static Map<Integer, String> say = new HashMap<>(
            Map.of(1, "1", 2, "11", 3, "21", 4, "1211", 5, "111221"));


    public static String countAndSayUtil(String str) {

        int len = str.length();
        Character lastValue = str.charAt(0);
        int count = 1;

        String ans = "";

        for (int index = 1; index < len; index++) {
            if (str.charAt(index) == lastValue) {
                count++;
            } else {
                ans = ans + String.valueOf(count) + String.valueOf(lastValue);
                count = 1;
                lastValue = str.charAt(index);
            }
        }
        ans = ans + String.valueOf(count) + String.valueOf(lastValue);
        return ans;
    }

    public static String countAndSay(int n) {

        String sayIt = say.get(n);
        if (sayIt != null) {
            return sayIt;
        }

        
        for (int i = 4; i <= n; i++) {
            sayIt = say.get(i);
            if (sayIt == null) {
                String sayItPrevious = say.get(i - 1);
                sayIt = countAndSayUtil(sayItPrevious);
                say.put(i, sayIt);
            }
        }

        return say.get(n);


    }

}