class Solution {


    public boolean canRemoveChar(Map<Character, Integer> mpExpected, Map<Character, Integer> mpActual, char c) {

        int countActual = mpActual.get(c);
        Integer countExpected = mpExpected.get(c);

        if (countExpected == null) {
            return true;
        }

        if (countActual > countExpected) {
            return true;
        }
        return false;
    }

    public void addCharInMap(Map<Character, Integer> mpActual, char c) {

        if (mpActual.get(c) == null) {
            mpActual.put(c, 1);
        } else {
            Integer count = mpActual.get(c);
            mpActual.replace(c, ++count);
        }

    }

    public void reduceCharCountInMap(Map<Character, Integer> mpActual, char c) {

        int countActual = mpActual.get(c);
        countActual--;
        mpActual.replace(c, countActual);
    }

    public boolean areMapsEqual(Map<Character, Integer> mpExpected, Map<Character, Integer> mpActual) {

//        if (mpExpected.size() != mpActual.size()) {
//            return false;
//        }

        for (Map.Entry<Character, Integer> entryExpected : mpExpected.entrySet()) {

            Integer countExpected = entryExpected.getValue();
            char c = entryExpected.getKey();
            Integer countActual = mpActual.get(c);

            if (countActual == null || countActual.compareTo(countExpected) < 0) {
                return false;
            }
        }
        return true;

    }

    public String minWindow(String s, String t) {

        int n = s.length();
        int m = t.length();

        if (n < m) {
            return "";
        }


        Map<Character, Integer> mpExpected = new HashMap<>();
        for (int i = 0; i < m; i++) {
            if (mpExpected.get(t.charAt(i)) == null) {
                mpExpected.put(t.charAt(i), 1);
            } else {
                Integer count = mpExpected.get(t.charAt(i));
                mpExpected.replace(t.charAt(i), ++count);
            }
        }


        int minLength = Integer.MAX_VALUE;
        int start = 0;
        String ansStr = "";

        Map<Character, Integer> mpActual = new HashMap<>();
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            if (mpActual.get(c) == null) {
                mpActual.put(c, 1);
            } else {
                Integer count = mpActual.get(c);
                mpActual.replace(c, ++count);
            }
        }

        boolean isEqual = areMapsEqual(mpExpected, mpActual);
        if (isEqual) {
            int currentLength = m;
            minLength = m;
            ansStr = s.substring(start, start + currentLength);
        }

        for (int i = m; i < n; i++) {

            char c = s.charAt(i);
            addCharInMap(mpActual, c);
            isEqual = areMapsEqual(mpExpected, mpActual);

            while (isEqual && start <= i && canRemoveChar(mpExpected, mpActual, s.charAt(start))) {
                reduceCharCountInMap(mpActual, s.charAt(start));
                start++;
            }
            int currentLength = i - start + 1;

            if (isEqual && currentLength < minLength) {
                minLength = currentLength;
                ansStr = s.substring(start, start + currentLength);
            }
        }

        return ansStr;

        
    }
}