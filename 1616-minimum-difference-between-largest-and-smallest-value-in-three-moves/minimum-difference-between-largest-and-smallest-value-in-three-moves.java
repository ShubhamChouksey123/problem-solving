class Solution {
    
    private static final int N = 4;

    private void getMaxElements(int[] nums, int n, List<Integer> maxElements){

        Queue<Integer> queue = new PriorityQueue<>();

        for(int num : nums){
            if(queue.size() < N){
                queue.add(num);
            }
            else{
                Integer top = queue.peek();
                if(num > top){
                    queue.poll();
                    queue.add(num);
                }
            }
        }

        maxElements.addAll(queue);

    }

    private void getMinElements(int[] nums, int n, List<Integer> minElements){

        Queue<Integer> queue = new PriorityQueue<>((a, b) -> (b -a));

        for(int num : nums){
            if(queue.size() < N){
                queue.add(num);
            }
            else{
                Integer top = queue.peek();
                if(num < top){
                    queue.poll();
                    queue.add(num);
                }
            }
        }

        minElements.addAll(queue);

    }

    private void removeDuplicates(int n, List<Integer> values){

        if(n >= 6){
            return;
        }
        
        Set<Integer> set = new TreeSet<>();
        for(Integer value : values){
            set.add(value);
        }

        n = set.size();
        while( values.size() > n){
            values.remove(n);
        }

        int index = 0;
        for(Integer value : set){
            values.set(index, value);index++;
        }
        
    }
    
    public int minDifference(int[] nums) {

        int n = nums.length;
        if(n <= 4){
            return 0;
        }

        List<Integer> maxElements = new ArrayList<>();
        getMaxElements(nums, n, maxElements);

        List<Integer> minElements = new ArrayList<>();
        getMinElements(nums, n, minElements);

        List<Integer> values = new ArrayList<>();
        values.addAll(minElements); 
        values.addAll(maxElements);

        Collections.sort(values);
        removeDuplicates(n, values);
 
        n = values.size();
        int minValue = Integer.MAX_VALUE;

        for(int i = 0 ;  i <= 3 ; i++){
            int diff = values.get(n-4+i) - values.get(i);
            minValue = Math.min(diff, minValue);
        }

        
        return minValue;
    }
}