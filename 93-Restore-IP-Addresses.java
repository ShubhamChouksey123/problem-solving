class Solution {

    private boolean isValidNum(String s){

        if(s.length() > 3 || s.isEmpty()) return false;
        
        int num = Integer.valueOf(s);

        if(num == 0) return s.length() == 1;
        if(s.charAt(0) == '0') return num == 0;

        if(num <= 255) return true;
        return false;
    }

    private void addToAns(List<String> ans, List<String> curr){
        if(curr.size() != 4) return;
        
        StringBuilder builder = new StringBuilder();
        builder.append(curr.get(0));
        for(int i = 1 ; i <= 3 ; i++){
            builder.append('.');
            builder.append(curr.get(i));
        }
        ans.add(builder.toString());
    }

    public void restoreIpAddresses(String s, List<String> ans, int index, List<String> curr, String str) {
        

        if(index == s.length()){

            if(isValidNum(str)){
                curr.add(str);
                addToAns(ans, curr);
                curr.remove(curr.size() - 1);
            }
            return;
        }

        if(str.length() > 3 || curr.size() > 4){
            return;
        }

        restoreIpAddresses(s, ans, index + 1, curr, str + s.charAt(index)) ;

        if(isValidNum(str)){
            curr.add(str);
            restoreIpAddresses(s, ans, index, curr, "") ;
            curr.remove(curr.size() - 1);
        }
        
    }
    
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        restoreIpAddresses(s, ans, 0, new ArrayList<>(), "");
        return ans; 
    }
}