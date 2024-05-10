class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        List<List<Integer>> sumTilNow = new ArrayList<>();
//        Arrays.fill(sumTilNow, Integer.MAX_VALUE);

        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                list.add(Integer.MAX_VALUE);
            }
            sumTilNow.add(list);
        }
        int corner = triangle.get(0).get(0);
        sumTilNow.get(0).set(0, corner);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {

                int element = triangle.get(i).get(j);
                if (j != 0) {
                    int val = Math.min(sumTilNow.get(i).get(j), sumTilNow.get(i - 1).get(j - 1) + element);
                    sumTilNow.get(i).set(j, val);
                }
                if (i != j) {
                    int val = Math.min(sumTilNow.get(i).get(j), sumTilNow.get(i - 1).get(j) + element);
                    sumTilNow.get(i).set(j, val);
                }
                // if (j + 1 < i) {
                //     int val = Math.min(sumTilNow.get(i).get(j), sumTilNow.get(i - 1).get(j + 1) + element);
                //     sumTilNow.get(i).set(j, val);
                // }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, sumTilNow.get(n - 1).get(j));
        }

        return ans;
    }
}