class Solution {
    public int minFlips(int a, int b, int c) {
        
        int first = 0, second = 0, output = 0, count = 0;
        while(a > 0 || b > 0 || c > 0){
            first = 0; second = 0; output = 0;
            if(a > 0){
                first = a%2;  a = a >> 1;
            }
            if(b > 0){
                second = b%2; b = b >> 1; 
            }
            if(c > 0){
                output = c%2; c = c >> 1;
            }
            if(first == 0 && second == 0 && output != 0){
                count++;
            }
            else if(first == 0 && second == 1 && output == 0){
                count++;
            }
            else if(first == 1 && second == 0 && output == 0){
                count++;
            }
            else if(first == 1 && second == 1 && output == 0){
                count += 2;
            }
        }
        return count;
    }
}