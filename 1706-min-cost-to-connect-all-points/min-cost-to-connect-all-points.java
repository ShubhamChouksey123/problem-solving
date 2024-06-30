class Solution {

    private int findParent(int a, int[] parents){
        if(parents[a] != a){
            parents[a] = findParent(parents[a], parents);
        }
        return parents[a];
    }

    private void union(int a, int b, int[] parents, int[] ranks){
        int aParent = findParent(a, parents);
        int bParent = findParent(b, parents);

        if(aParent == bParent){
            return;
        }

        if(ranks[aParent] < ranks[bParent]){
            parents[aParent] = bParent;
        }
        else if(ranks[aParent] > ranks[bParent]){
            parents[bParent] = aParent;
        }
        else{
            parents[aParent] = bParent;
            ranks[bParent]++;
        }
    }

    private boolean isConnected(int a, int b, int[] parents, int[] ranks){
        int aParent = findParent(a, parents);
        int bParent = findParent(b, parents);

        if(aParent == bParent){
            return true;
        }
        return false;
    }

    private void print(List<Integer[]> sortedPoints){
        for(int i = 0; i < sortedPoints.size() ; i++){
            Integer[] inner = sortedPoints.get(i);
            for(Integer a : inner){
                System.out.print(a + " ");
            }
            System.out.println(" ");
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        int[] parents = new int[n];
        int[] ranks = new int[n];
        for(int i = 0 ; i < n ; i++){
            parents[i] = i;
            ranks[i] = 1;
        }


        List<Integer[]> sortedPoints = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            int x = points[i][0];
            int y = points[i][1];
            for(int j = i + 1 ; j < n ; j++){
                int distance = Math.abs(x - points[j][0]) + Math.abs(y - points[j][1]); 
                sortedPoints.add(new Integer[]{distance, i, j});
            }
        }

        Collections.sort(sortedPoints, 
            (a, b)->{
                return a[0] - b[0];
            }
        );

        int cost = 0, count = 0, i = 0;

        while(count < n-1){
            Integer[] point = sortedPoints.get(i);
            int a = point[1];
            int b = point[2];
            if(!isConnected(a, b, parents, ranks)){
                cost += point[0]; count++;
                union(a, b, parents, ranks);
            }
            i++;
        }

        return cost;
    }
}