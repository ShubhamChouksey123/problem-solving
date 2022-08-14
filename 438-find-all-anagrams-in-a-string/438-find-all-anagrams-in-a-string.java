class Solution {
    
    public List<Integer> findAnagrams(String s, String p) {
        
        int[] actual = new int[26];
        int[] expected = new int[26];
        
        int n = p.length();
        for(int i = 0 ; i < p.length() ; i++){
            char c = p.charAt(i);
            expected[c - 'a']++;
        }
        int count = 0;
        for(int i = 0 ; i < Math.min(p.length(), s.length()) ; i++ ){
            char c = s.charAt(i);
            actual[c - 'a']++;
        }
        
        
        for(int i = 0 ; i < 26 ; i++){
            int temp = (expected[i] >= actual[i]) ?  actual[i] :  expected[i];
            count += temp;
        }
        
        int ans = 0;
        
        List<Integer> listOfAnagramIdex = new ArrayList<>();
        if(count == n)
            listOfAnagramIdex.add(0);
        
        
        
        for(int i = 1; i <= (s.length() - p.length()) ; i++){
            int newEntryIndex = i + n -1;
            int index = s.charAt(newEntryIndex) - 'a';
            
            int temp = (expected[index] > actual[index]) ?  1 :  0;
            count += temp;
            
            actual[index]++;
            
            index = s.charAt(i-1) - 'a';
            temp = (expected[index] >= actual[index]) ?  -1 :  0;
            count += temp;
            
            actual[index]--;
            
            if(count == n)
                listOfAnagramIdex.add(i);
            
        }
        return listOfAnagramIdex;
    }
}