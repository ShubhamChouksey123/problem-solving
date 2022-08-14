class Solution {
    
    
  public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> mp = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            Integer currentCount = mp.get(words[i]);

            if (currentCount == null) {
                currentCount = Integer.valueOf(0);
            }

            mp.put(words[i], currentCount + 1);
        }


        Map<Integer, Set<String>> countMap = new TreeMap<>();
        for (Map.Entry<String, Integer> element : mp.entrySet()) {

            Integer count = element.getValue();
            String str = element.getKey();
            Set<String> st = countMap.get(count);

            if (st == null) {
                st = new TreeSet<String>();
            }
            st.add(str);
            countMap.put(element.getValue(), st);
        }
        // System.out.println("countMap : " + countMap);

        Map<Integer, Set<String>> reverseMap = ((TreeMap<Integer, Set<String>>) countMap).descendingMap();

        List<String> list = new ArrayList<>();

        for (Map.Entry<Integer, Set<String>> eachElement : reverseMap.entrySet()) {
            if (list.size() >= k)
                break;

            Set<String> stringSet = eachElement.getValue();

            for (String string : stringSet) {
                if (list.size() >= k)
                    break;
                list.add(string);
            }
        }


        return list;

    }
}