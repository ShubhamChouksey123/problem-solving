class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> row = new ArrayList<>();
        row.add(1);
        result.add(row);

        for(int i = 1 ; i < numRows ; i++){
            result.add(new ArrayList<>());
            for(int j = 0 ; j <= i ; j++){
                int topLeft = 0;
                if(j - 1 >= 0){
                    topLeft = result.get(i-1).get(j-1);
                }
                int top = 0;
                if(j < i){
                    top = result.get(i-1).get(j);
                }
                result.get(i).add(topLeft + top);
            }
        }

        return result;
    }
}