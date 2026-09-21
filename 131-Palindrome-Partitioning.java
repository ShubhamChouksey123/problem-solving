class Solution {

    private boolean isPalindrom(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public void partition(String s, List<List<String>> result, int start, List<String> cur) {
        
        if(start == s.length()) {
            result.add(new ArrayList<>(cur)); return;
        }

        for(int end = start ; end < s.length() ; end++){
            String substring = s.substring(start, end + 1);
            if(isPalindrom(s, start, end)){
                cur.add(substring);
                partition(s, result, end + 1, cur); 
                cur.remove(cur.size() - 1);
            }
        }
    }

    public List partition(String s) {
        
        int n = s.length();
        List<List<String>> result = new ArrayList<>();
        partition(s, result, 0, new ArrayList<>());
        return result;
    }
}