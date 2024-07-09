class Solution {
    public int compareVersion(String version1, String version2) {

        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");

        System.out.println("ver1 : " + Arrays.toString(ver1));
        System.out.println("ver2 : " + Arrays.toString(ver2));

        Integer first, second;
        for(int i = 0; i < Math.max(ver1.length, ver2.length) ; i++){
            first = 0; second = 0;
            if(i < ver1.length){
                first = Integer.valueOf(ver1[i]);
            }
            if(i < ver2.length){
                second = Integer.valueOf(ver2[i]);
            }

            if(first < second){
                return -1;
            }
            else if(first > second){
                return 1;
            }
        }

        return 0;

    }
}