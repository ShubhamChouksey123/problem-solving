class Solution {
    public void letterCombinationsUtil(String digits, int n, int index, String s, char[][] mappedChar, List<String> ans) {

        if (index == n) {
            ans.add(s);
            return;
        }

        int digit = digits.charAt(index) - '2';

        for (int i = 0; i < mappedChar[digit].length; i++) {
            letterCombinationsUtil(digits, n, index + 1, s + mappedChar[digit][i], mappedChar, ans);
        }
    }

    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();
        int n = digits.length();
        if (n == 0) {
            return ans;
        }


        char[][] mappedChar = new char[][]{
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'},
        };

        letterCombinationsUtil(digits, n, 0, "", mappedChar, ans);

        return ans;
    }
}