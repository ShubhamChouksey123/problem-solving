class Solution {
    public String[] sortPeople(String[] names, int[] heights) {

        int n = names.length;
        String[] ans = new String[n];
        Map<Integer, String> heightPeoples = new TreeMap<>();

        for(int i = 0 ; i < n; i++){
            heightPeoples.put(heights[i], names[i]);
        }

        int index = n-1;
        for(Map.Entry<Integer, String> entry : heightPeoples.entrySet()){
            ans[index] = entry.getValue();
            index--;
        }
        
        return ans;
    }
}