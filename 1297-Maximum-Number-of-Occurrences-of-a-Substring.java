class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

        int start = 0, end = 0;
        int n = s.length();
        Map<Character, Integer> lastIndexAt = new HashMap<>(); 
        Set<Character> distinctCharInWindow = new HashSet<>(); 
        Map<String, Integer> substringOccurances = new HashMap<>(); 

        for(end = 0 ; end < n ; end++){

            char c = s.charAt(end);
            lastIndexAt.put(c, end);
            distinctCharInWindow.add(c);
            
            if(end - start + 1 > minSize){
                char startChar = s.charAt(start);
                if(lastIndexAt.get(startChar) == start){
                    distinctCharInWindow.remove(startChar);
                }
                start++;
            }

            if(distinctCharInWindow.size() <= maxLetters && end - start + 1 == minSize){
                String tmp = s.substring(start, end + 1);
                substringOccurances.put(tmp, substringOccurances.getOrDefault(tmp, 0) + 1);
                
            }
        }

        int maxValue = 0;
        for(int time : substringOccurances.values()){
            maxValue = Math.max(maxValue, time);
        }
        return maxValue;
    }
}