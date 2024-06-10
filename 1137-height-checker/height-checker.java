class Solution {
    public int heightChecker(int[] heights) {

        int n = heights.length;
        List<Integer> sortedHeights = new ArrayList<>();
        Arrays.stream(heights).boxed().forEach(a -> sortedHeights.add(a));

        Collections.sort(sortedHeights);

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (heights[i] != sortedHeights.get(i)) {
                count++;
            }
        }
        return count;
    }
}