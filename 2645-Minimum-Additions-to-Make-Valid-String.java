class Solution {

    Map<Character, Integer> charIndex = Map.of(
        'a', 0,
        'b', 1,
        'c', 2
    );

    public int addMinimum(String word) {
       
        int n = word.length();
        int count = 0;

        int prevIndex = charIndex.get(word.charAt(0));
        if(prevIndex == 1) count++;
        else if(prevIndex == 2) count = count + 2;

        for(int i = 1 ; i < word.length() ; i++){
            int currentIndex = charIndex.get(word.charAt(i));
            if(prevIndex == currentIndex) {
                count = count + 2;
            }
            else if( (prevIndex + 1) % 3 == currentIndex){
                prevIndex = currentIndex;
                continue;
            }
            else{
                count = count + 1;
            }
            prevIndex = currentIndex;
        }
        if(prevIndex == 0) count = count + 2;
        else if(prevIndex == 1) count = count + 1;

        return count;
    }
}