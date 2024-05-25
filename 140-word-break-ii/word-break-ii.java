class Solution {
    

    private List<String> sequences = new ArrayList<>();

    private void convertToString(List<String> currentSeq) {
        if (currentSeq.isEmpty())
            return;

        StringBuilder ans = new StringBuilder();
        ans.append(currentSeq.get(0));

        for (int i = 1; i < currentSeq.size(); i++) {
            ans.append(" ");
            ans.append(currentSeq.get(i));
        }
        sequences.add(String.valueOf(ans));
    }

    private void wordBreakUtil(String s, int len, List<String> wordDict, int n, int index, List<String> currentSeq) {

        if (index == len) {
            convertToString(currentSeq);
            return;
        }

        for (int i = 0; i < n; i++) {
            String wordExpected = wordDict.get(i);
            int wordLength = wordExpected.length();
            if (index + wordLength > len) {
                continue;
            }
            String wordActual = s.substring(index, index + wordLength);
            if (Objects.equals(wordActual, wordExpected)) {
                currentSeq.add(wordExpected);
                wordBreakUtil(s, len, wordDict, n, index + wordLength, currentSeq);
                currentSeq.remove(currentSeq.size() - 1);
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        wordBreakUtil(s, s.length(), wordDict, wordDict.size(), 0, new ArrayList<>());
        return sequences;
    }
}