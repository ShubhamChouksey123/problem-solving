class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int n = arr1.length;
        int[] ans = new int[n];
        int index = 0;

        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : arr1) {
            Integer freq = counts.get(num);
            if (freq == null) {
                freq = 0;
            }
            counts.put(num, freq + 1);
        }

        for (int i = 0; i < arr2.length; i++) {
            int num = arr2[i];
            Integer freq = counts.get(num);
            if (freq == null) {
                freq = 0;
            }
            while (freq > 0) {
                ans[index] = num;
                index++;
                freq--;
            }
            counts.put(num, 0);
        }

        List<Integer> nonExistingElements = new ArrayList<>();
        counts.forEach((k, v) -> {

            if (v != 0) {
                while (v > 0) {
                    nonExistingElements.add(k);
                    v--;
                }
            }
        });

        Collections.sort(nonExistingElements);

        int currentIndex = 0;

        for (int i = n - nonExistingElements.size(); i < n; i++, currentIndex++) {
            ans[i] = nonExistingElements.get(currentIndex);

        }

        System.out.println("ans : " + Arrays.toString(ans));

        return ans;
    }
}