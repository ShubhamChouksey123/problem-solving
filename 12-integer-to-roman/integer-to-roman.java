class Solution {
    public static int[] mappedNumber = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public static String[] encodedChar = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public String intToRoman(Integer num) {
        
        StringBuilder ans = new StringBuilder();


        for (int i = 0; i < mappedNumber.length; i++) {
            // System.out.println("mappedNumber : " + mappedNumber[i] + " with value : " + encodedChar[i]);

            int matchedKey = mappedNumber[i];
            if (num.compareTo(mappedNumber[i]) >= 0) {

                while (num >= matchedKey) {
                    ans.append(encodedChar[i]);
                    num = num - matchedKey;
                }
            }

        }


        return ans.toString();
    }
}