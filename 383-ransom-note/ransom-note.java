class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] counts = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            counts[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int num = ransomNote.charAt(i) - 'a';
            if (counts[num] == 0) {
                return false;
            }
            counts[num]--;
        }
        return true;
    }
}