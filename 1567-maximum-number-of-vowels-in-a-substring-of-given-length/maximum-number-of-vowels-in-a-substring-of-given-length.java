class Solution {
    
    private boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }

    public int maxVowels(String s, int k) {
        
        int n = s.length(), vowelCount = 0, maxVowelCount = 0;

        for(int i = 0 ; i < Math.min(k, n) ; i++){
            if(isVowel(s.charAt(i))){
                vowelCount++;
            }
        }

        maxVowelCount = Math.max(maxVowelCount, vowelCount);

        for(int i = k ; i < n ; i++){
            if(isVowel(s.charAt(i-k))){
                vowelCount--;
            }
            if(isVowel(s.charAt(i))){
                vowelCount++;
            }
            maxVowelCount = Math.max(maxVowelCount, vowelCount);
        }
        return maxVowelCount;
    }
}