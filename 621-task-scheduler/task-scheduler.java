class Solution {

    class Node{
        private Character c;
        private int times;
        private int nextAvaTime;

        public Node(Character c, int times, int nextAvaTime){
            this.c = c;
            this.times = times;
            this.nextAvaTime = nextAvaTime;
        }

    }

    private void createMaxHeap(char[] tasks, Queue<Node> maxHeap){
        int[] counts = new int[26];
        for(char task : tasks){
            counts[task-'A']++;
        }

        for(int i = 0 ; i < 26 ; i++){
            if(counts[i] > 0){
                Node node = new Node((char)('A' + i), counts[i], 0);
                maxHeap.add(node);
            }
        }
    }

    public int leastInterval(char[] tasks, int n) {
        Queue<Node> maxHeap = new PriorityQueue<>((a, b) -> {
            return b.times - a.times; 
        });
        Queue<Node> queue = new LinkedList<>();

        createMaxHeap(tasks, queue);

        int t = 0;
        while(!queue.isEmpty() || !maxHeap.isEmpty()){
            
            while(!queue.isEmpty() && queue.peek().nextAvaTime <= t){
                Node node = queue.poll();
                maxHeap.add(node);
            }

            t++;

            if(!maxHeap.isEmpty()){
                Node top = maxHeap.poll();    
                top.times--;
                top.nextAvaTime = t + n;
                if(top.times > 0){
                    queue.add(top);
                }
            }
        }

        return t;
    }
}