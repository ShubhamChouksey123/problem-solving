class Solution {

    private int countFive;
    private int countTen;

    public boolean lemonadeChange(int bill) {
        bill = bill - 5;
        if(bill >= 10){
            int used = Math.min(countTen, bill/10);
            countTen = countTen - used;
            bill = bill - (10* used);
        }

        if(bill >= 5){
            int used = Math.min(countFive, bill/5);
            countFive = countFive - used;
            bill = bill - (5* used);
        }

        // System.out.println("rem countFive : " + countFive + " and countTen : " + countTen);
        if(bill == 0)
            return true;
        return false;
    }

    public boolean lemonadeChange(int[] bills) {

        for(int bill : bills){
            // System.out.println("bill : " + bill);
            // System.out.println("countFive : " + countFive + " and countTen : " + countTen);
            if(bill != 5){
                if(!lemonadeChange(bill)){
                    return false;
                }
            }

            if(bill == 5){
                countFive++;
                
            }else if(bill == 10){
                countTen++;
            }
            // System.out.println("countFive : " + countFive + " and countTen : " + countTen);
        }

        return true;   
    }
}