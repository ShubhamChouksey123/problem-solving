class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        int length = s.length();


        PriorityQueue<Integer> startSet = new PriorityQueue<>();
        startSet.add(0);
        boolean[] isAlreadyVisited = new boolean[length];


        while (!startSet.isEmpty()) {
            int start = startSet.poll();
            if (start == length)
                return true;

            if (isAlreadyVisited[start]) {
                continue;
            }


            for (String word : wordDict) {
                int wordLength = word.length();
                if (start + wordLength > length) {
                    continue;
                }
                String wordString = s.substring(start, start + wordLength);
                if (Objects.equals(word, wordString)) {
                    startSet.add(start + wordLength);
                }
            }
            isAlreadyVisited[start] = true;
        }
        return false;
    }
}