class Solution {
    public int compareVersion(String version1, String version2) {

        String[] str1 = version1.split("\\.");
        System.out.println("str1 : " + Arrays.toString(str1));


        String[] str2 = version2.split("\\.");
        System.out.println("str2 : " + Arrays.toString(str2));

        for (int i = 0; i < Math.max(str1.length, str2.length); i++) {

            Integer num1 = 0;
            Integer num2 = 0;
            if (i < str1.length) {
                num1 = Integer.valueOf(str1[i]);
            }
            if (i < str2.length) {
                num2 = Integer.valueOf(str2[i]);
            }

            System.out.println("num1 : " + num1 + " and num2 : " + num2);

            if (num1.compareTo(num2) < 0) {
                return -1;
            } else if (num1.compareTo(num2) > 0) {
                return 1;
            }
        }


        return 0;
    }

}