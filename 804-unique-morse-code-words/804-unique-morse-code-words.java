class Solution {
    
    private String[] values = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    
    private String convertToMorseCode(String word){
        
        String convertedText = "";
        for(int i = 0 ; i < word.length() ; i++){
            convertedText = convertedText + values[word.charAt(i) - 'a'];
        }
        return convertedText;
    }
    
    public int uniqueMorseRepresentations(String[] words) {
        
        Map<String, Integer> count = new HashMap<>();
        
        for(int i = 0 ; i < words.length ; i++){
            
            String morseText = convertToMorseCode(words[i]);
            Integer curCount = count.get(morseText);
            if(curCount == null){
                curCount = 0;
            }
            count.put(morseText, ++curCount);
        }
        
        // System.out.println("count Map : " + count);
        
        return count.size();
    }
}