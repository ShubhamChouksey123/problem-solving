class Solution {

    private List<List<Integer>> ans ;

    private void generateArray(int k, int n, int start, int sum, List<Integer> numbers){

        if(numbers.size() == k){
            if(sum == n){
                ans.add(new ArrayList<>(numbers));
            }
        }

        for(int i = start ; i <= Math.min(9, n) ; i++){
            numbers.add(i);
            generateArray(k, n, i+1, sum + i, numbers);
            numbers.remove(numbers.size() -1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>(); 
        List<Integer> numbers = new ArrayList<>();
        generateArray(k, n, 1, 0, numbers);

        return ans;
    }
}