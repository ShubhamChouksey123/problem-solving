class Solution {
    private boolean isPalindrome(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private void partitionUtil(String s, List<List<String>> ans, List<String> cur, int index, int n) {

        if (index == n) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = index; i < n; i++) {
            String str = s.substring(index, i + 1);
            if (!isPalindrome(str))
                continue;

            cur.add(str);
            partitionUtil(s, ans, cur, i + 1, n);
            cur.remove(cur.size() - 1);
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        partitionUtil(s, ans, new ArrayList<>(), 0, s.length());
        return ans;
    }
}
