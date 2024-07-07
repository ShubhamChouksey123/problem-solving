class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] strings = s.split(" ");

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = strings.length - 1; i >= 0 ; i--){
            String str = strings[i].trim();
            if(str.length() == 0){
                continue;
            }
            if(i != strings.length - 1){
                stringBuilder.append(" ");
            }
            stringBuilder.append(strings[i].trim());
        }
        // System.out.println("strings : " + Arrays.toString(strings));

        String ans = stringBuilder.toString();
        ans.trim();
        return ans;
    }
}