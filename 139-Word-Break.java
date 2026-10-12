class Solution {
    
    public boolean wordBreak(String s, Set<String> wordDict, Boolean[] memoCache, int start) {

        if(start == s.length()) return true;
        if(memoCache[start] != null) return memoCache[start];

        boolean isPossible = false;

        for(int end = start ; end < s.length() ; end++){
            String substring = s.substring(start, end + 1);
            if(wordDict.contains(substring)){
                isPossible = isPossible || wordBreak(s, wordDict, memoCache, end + 1);
            }
        }

        memoCache[start] = isPossible;
        return isPossible;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> wordDictSet = new HashSet<>();
        for(String word : wordDict){
            wordDictSet.add(word);  
        }

        Boolean[] memoCache = new Boolean[s.length()];
        return wordBreak(s, wordDictSet, memoCache, 0) ;
        
    }
}