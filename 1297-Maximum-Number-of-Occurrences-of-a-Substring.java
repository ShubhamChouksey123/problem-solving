class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        
        int start = 0, end = 0;
        int n = s.length();
        Set<Character> windowsChars = new HashSet<>(); 
        int[] lastIndexAt = new int[26];
        Map<String, Integer> stringOccurances = new HashMap<>();


        for(end = 0; end < n ; end++){
            char c = s.charAt(end);
            windowsChars.add(c);
            lastIndexAt[c - 'a'] = end;

            while(windowsChars.size() > maxLetters){
                char startChar = s.charAt(start);
                if(lastIndexAt[startChar - 'a'] == start){
                    windowsChars.remove(startChar);
                }
                start++;
            }

            while(end - start + 1 > maxSize){
                char startChar = s.charAt(start);
                if(lastIndexAt[startChar - 'a'] == start){
                    windowsChars.remove(startChar);
                }
                start++;
            }

            int tmpStart = start;
            while(end - tmpStart + 1 >= minSize && tmpStart < n){
                String tmp = s.substring(tmpStart, end + 1);
                stringOccurances.put(tmp, stringOccurances.getOrDefault(tmp, 0) + 1);
                tmpStart++;
            }
        }
        int maxValue = 0;
        for(int time : stringOccurances.values()){
            maxValue = Math.max(time, maxValue);
        }
        // System.out.println(stringOccurances);
        return maxValue;
    }
}