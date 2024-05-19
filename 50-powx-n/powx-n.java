    
public class Solution{

     private double myPowUtil(double x, int n, Map<Integer, Double> mp) {

        if (mp.containsKey(n)) {
            return mp.get(n);
        }

        if (n % 2 == 0) {
            double value = myPowUtil(x, n / 2, mp);
            mp.put(n, value * value);
            return mp.get(n);
        }

        double value = myPowUtil(x, n / 2, mp);
        mp.put(n, x * value * value);
        return mp.get(n);
    }

    private double myPowUtil(double x, int n) {

        if (n == Integer.MAX_VALUE) {
            long nValue = (long) Integer.MAX_VALUE - 1;
            n = (int) nValue;
        }

        Map<Integer, Double> mp = new HashMap<>();
        mp.put(0, 1.0);
        mp.put(1, x);
        mp.put(2, x * x);

        return myPowUtil(x, n, mp);
    }

    public double myPow(double x, int n) {


        if (n == -1) {
            return 1 / x;
        }
        if (n == 1) {
            return x;
        }
        if (x < 0 && (double) n % 2 == 0) {
            x = x * -1;
        }
        if (x == 0 || x == 1) {
            return x;
        }
        if(x == -1 && Objects.equals(n, Integer.MAX_VALUE)){
            return -1;
        }
        if(x == -1 && Objects.equals(n, Integer.MIN_VALUE)){
            return -1;
        }
        if (n == 0) {
            return 1;
        }

        if (Objects.equals(n, Integer.MIN_VALUE)) {
            return myPowUtil(1 / x, Integer.MAX_VALUE);
        }
        if (n < 0) {
            return myPowUtil(1 / x, n * -1);
        }

        return myPowUtil(x, n);
    }
}    
    

