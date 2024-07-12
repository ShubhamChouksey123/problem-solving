class Solution {
    public String predictPartyVictory(String senate) {

        char[] chars = senate.toCharArray();
        int deleteR = 0, deleteD = 0, countR = 0, countD = 0;

        Queue<Character> queue = new LinkedList<>();
        for(char c : chars){
            System.out.println("c : " + c);
            if(Objects.equals(c, 'R')){
                countR++;
            }else{
                countD++;
            }
            queue.add(c);
        }


        while(!queue.isEmpty()){
            Character top = queue.poll();
            

            if(countR == 0){
                return "Dire";
            }else if(countD == 0){
                return "Radiant";
            }

            if(Objects.equals(top,'R')){
                if(deleteR > 0){
                    deleteR--;
                    countR--;
                }else{
                    deleteD++;
                    queue.add('R');
                }
            }else {
                if(deleteD > 0){
                    deleteD--;
                    countD--;
                }else{
                    deleteR++;
                    queue.add('D');
                }
            }

           
        }


        return "";
        
    }
}