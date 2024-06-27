class Solution {
    
    private boolean getCounts(Map<Character, Integer> map1, Map<Character, Integer> map2){
        List<Integer> counts1 = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry : map1.entrySet()){
            counts1.add(entry.getValue());
        }

        Collections.sort(counts1);
        System.out.println("counts1 : " + counts1);

        List<Integer> counts2 = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry : map2.entrySet()){
            counts2.add(entry.getValue());
        }

        Collections.sort(counts2);
        System.out.println("counts2 : " + counts2);

        if(counts1.size() != counts2.size()){
            System.out.println("different sizes");
            return false;
        }

        for(int i = 0 ; i < counts1.size() ; i++){
            if(!Objects.equals(counts1.get(i), counts2.get(i))){
                // System.out.println("different for i : " + i);
                return false;
            }
        }
        return true;
    }

    private boolean containsAtLeastOne(String word1, String word2,Map<Character, Integer> map1, Map<Character, Integer> map2, int n) {

        for (int i = 0; i < n; i++) {
            char c = word1.charAt(i);
            map1.merge(c, 1, Integer::sum);
        }

        for (int i = 0; i < n; i++) {
            char c = word2.charAt(i);
            map2.merge(c, 1, Integer::sum);
        }

        for (Map.Entry<Character, Integer> me : map1.entrySet()) {

            Character c = me.getKey();
            Integer count = map2.get(c);
            if (count == null || count == 0) {
                return false;
            }
        }

        return true;
    }

    public boolean closeStrings(String word1, String word2) {

        if (word1.length() != word2.length()) {
            return false;
        }
        int n = word1.length();

        Map<Character, Integer> map1 = new TreeMap<>();
        Map<Character, Integer> map2 = new TreeMap<>();

        if (!containsAtLeastOne(word1, word2, map1, map2, n)) {
            return false;
        }

        if(!getCounts(map1, map2)){
            System.out.println("false in this");
            return false;
        }
        return true;
    }
}