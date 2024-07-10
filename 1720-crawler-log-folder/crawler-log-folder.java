class Solution {
    public int minOperations(String[] logs) {
        
        Stack<String> st = new Stack<>();
        for(int i = 0 ; i < logs.length; i++){
            if(Objects.equals("../", logs[i])){
                if(st.size() > 0){
                    st.pop();
                }
            }else if(Objects.equals("./", logs[i])){

            }
            else{
                st.push(logs[i]);
            }
        }

        return st.size();
    }
}