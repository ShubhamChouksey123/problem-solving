class Solution {

    private static final int TOTAL_CHARS = 26;

    public int minimumPushes(String word) {

        int[] charCount = new int[TOTAL_CHARS];
        for(char c : word.toCharArray()){
            charCount[c - 'a']++;
        }

        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(int count : charCount){
            maxHeap.offer(count);
        }

        int index = 0;
        int pushes = 0;
        while(!maxHeap.isEmpty()){
            int count = maxHeap.poll();
            pushes += count * ((index/8) + 1);
            index++;
        }
        return pushes;
    }
}