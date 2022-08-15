import java.util.Map;
import static java.util.Map.entry;

class Solution {
    
    private static Map<Character, Integer> decode = Map.ofEntries(
            entry('I', 1),
            entry('V', 5),
            entry('X', 10),
            entry('L', 50),
            entry('C', 100),
            entry('D', 500),
            entry('M', 1000)
    );
    

    
    public int romanToInt(String s) {

        int n = s.length();

        Character prev = null;
        Character curr = s.charAt(0);

        Integer sum = 0;
        sum += decode.get(curr);
        prev = curr;

        for (int i = 1; i < n; i++) {
            curr = s.charAt(i);
            if (decode.get(curr) > decode.get(prev)) {
                sum = sum - (2 * decode.get(prev)) + decode.get(curr);
            } else {
                sum += decode.get(curr);
            }
            prev = curr;
        }


        return sum;


    }
    
}