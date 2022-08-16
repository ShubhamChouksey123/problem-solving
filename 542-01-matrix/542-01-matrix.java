class Solution {
    
    class Coordinate {

        private Integer x;
        private Integer y;

        private Integer dist;

        public Coordinate() {
        }

        public Coordinate(Integer x, Integer y, Integer dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        public Integer getX() {
            return x;
        }

        public void setX(Integer x) {
            this.x = x;
        }

        public Integer getY() {
            return y;
        }

        public void setY(Integer y) {
            this.y = y;
        }

        public Integer getDist() {
            return dist;
        }

        public void setDist(Integer dist) {
            this.dist = dist;
        }

    
    }
    
    
    
    private static final int xOffset[] = {1, 0, -1, 0};
    private static final int yOffset[] = {0, 1, 0, -1};


    private boolean liesInRange(int x, int y, int n, int m){
        if(x >=0 && x < n && y >= 0 && y < m){
            return true;
        }
        return false;
    }

    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int[][] minDist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                minDist[i][j] = -1;
            }
        }

        Queue<Coordinate> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    minDist[i][j] = 0;
                    for (int k = 0; k < xOffset.length; k++) {
                        if (liesInRange(i + xOffset[k] , j + yOffset[k] ,  n ,  m) && mat[i + xOffset[k]][j + yOffset[k]] == 1) {
                            Coordinate coordinate = new Coordinate(i + xOffset[k], j + yOffset[k], 1);
                            queue.add(coordinate);
                        }
                    }
                }
            }
        }


        // System.out.println("queue : " + queue);

        while(queue.size() > 0){

            Coordinate coordinate = queue.remove();
            Integer x = coordinate.getX();
            Integer y = coordinate.getY();
            Integer dist = coordinate.getDist();

            if(minDist[x][y] == -1){
                minDist[x][y] = dist;
                for (int k = 0; k < xOffset.length; k++) {
                    if (liesInRange(x + xOffset[k] , y + yOffset[k] ,  n ,  m) && minDist[x + xOffset[k]][y + yOffset[k]] == -1) {
                        Coordinate coordinateNeighbour = new Coordinate(x + xOffset[k], y + yOffset[k], dist + 1);
                        queue.add(coordinateNeighbour);
                    }
                }
            }
        }

        
        return minDist;
    }
    
}