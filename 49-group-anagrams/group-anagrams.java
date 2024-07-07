class Solution {


    private String getKey(String s){
        int[] counts = new int[26];
        int n = s.length();
        for(int i = 0; i < n ; i++){
            counts[s.charAt(i) - 'a']++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < 26 ; i++){
            if(counts[i] > 0){
                char c = (char)('a' + i);
                stringBuilder.append(c);
                stringBuilder.append(String.valueOf(counts[i]));
            }
        }

        return stringBuilder.toString();
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {

        int n = strs.length;

        Map<String, List<String>> mp = new HashMap<>();

        for(String str : strs){
            String key = getKey(str);
            List<String> currentList = mp.get(key);
            if(currentList == null){
                List<String> newList = new ArrayList<>();
                newList.add(str);
                mp.put(key, newList);
            }else{
                currentList.add(str);
            }
        }


        List<List<String>> ans = new ArrayList<>();
        mp.forEach(
            (k, v) -> {
                ans.add(v);
            }
        );
        
        return ans;
    }
}