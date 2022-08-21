class Solution {
    
    
    public void letterCasePermutation(String s, int n,int i, String cur, List<String> output) {
        if(i == n){
            output.add(cur);
            return;
        }
        Character c = s.charAt(i);
        
        if(c <= '9' && c >= '0'){
            letterCasePermutation( s,  n, i+1,  cur + String.valueOf(c), output);
            return;
        }
        
        
        Character lower = Character.toLowerCase(c);
        Character upper = Character.toUpperCase(c);
        
        letterCasePermutation( s,  n, i+1,  cur + String.valueOf(lower), output);
        letterCasePermutation( s,  n, i+1,  cur + String.valueOf(upper), output);
        
    }
    
    public List<String> letterCasePermutation(String s) {
    
        List<String> output = new ArrayList<>();
        letterCasePermutation( s,  s.length(), 0, "", output);
        return output;
            
        
    }
}