
import static java.util.Map.entry;

class Solution {
    
    Map<Integer, List<Character>> mp =  Map.ofEntries(
        entry(2, Arrays.asList('a', 'b', 'c')), 
        entry(3, Arrays.asList('d', 'e', 'f')), 
        entry(4, Arrays.asList('g', 'h', 'i')),
        entry(5, Arrays.asList('j', 'k', 'l')),
        entry(6, Arrays.asList('m', 'n', 'o')),
        entry(7, Arrays.asList('p', 'q', 'r', 's')),
        entry(8, Arrays.asList('t', 'u', 'v')),
        entry(9, Arrays.asList('w', 'x', 'y', 'z'))
    );

    

    public void letterCombinations(String digits, List<Character> word, List<String> ans) {

        if(word.size() == digits.length()){
            if(word.size() == 0)
                return ;
            StringBuilder stringBuilder = new StringBuilder();
            for(Character c : word){
                stringBuilder.append(c);
            } 
            ans.add(stringBuilder.toString());
            return;
        }
        
        int digit = digits.charAt(word.size()) - '0';
        for(Character c : mp.get(digit)){
            word.add(c);
            letterCombinations(digits, word, ans);
            word.remove(word.size() - 1);
        }
    }

    
    public List<String> letterCombinations(String digits) {

        // System.out.println("mp : " + mp);
        List<String> ans = new ArrayList<>();
        letterCombinations(digits, new ArrayList<>(), ans);

        return ans;
    }
}