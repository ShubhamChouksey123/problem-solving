class Solution {


    Map<Integer, List<Character>> mp; 

    private void letterCombinations(String digits, List<String> result, int index, StringBuilder builder) {
        
        if(index == digits.length()){
            result.add(builder.toString()); return;
        }

        int num = Integer.valueOf(digits.charAt(index) - '0');
        for(char c : mp.get(num)){

            builder.append(c);

            letterCombinations(digits, result, index + 1, builder); 

            builder.deleteCharAt(builder.length() - 1);
        }

    }

    public List<String> letterCombinations(String digits) {
        
        mp = new HashMap<>();
        
        mp.put(2, List.of('a', 'b', 'c'));
        mp.put(3, List.of('d', 'e', 'f'));
        mp.put(4, List.of('g', 'h', 'i'));
        mp.put(5, List.of('j', 'k', 'l'));
        mp.put(6, List.of('m', 'n', 'o'));
        mp.put(7, List.of('p', 'q', 'r', 's'));
        mp.put(8, List.of('t', 'u', 'v'));
        mp.put(9, List.of('w', 'x', 'y', 'z'));

        List<String> result = new ArrayList<>();

        letterCombinations(digits, result, 0, new StringBuilder());
        return result; 
    }
}