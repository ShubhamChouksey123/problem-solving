class Solution {

    private final int minSpace = 1; 

    private String createLastLine(String[] words, int start, int end, int wordWidth, int maxWidth){

        int spaces = maxWidth - wordWidth;
        int totalWords = end - start + 1;
        
        int equalSpaces = 1;
        
        StringBuilder builder = new StringBuilder();
        for(int i = start ; i <= end; i++){
            builder.append(words[i]);
            if(i != end){
                int totalSpaces = equalSpaces;
                for(int j = 0 ; j < totalSpaces ; j++) builder.append(" ");
            }
        }

        int currentLength = builder.toString().length();
        for(int j = 0 ; j < (maxWidth - currentLength) ; j++) builder.append(" ");
        return builder.toString();

    }


    private String createNormalLine(String[] words, int start, int end, int wordWidth, int maxWidth){

        int spaces = maxWidth - wordWidth;
        int totalWords = end - start + 1;
        if(totalWords == 1) return "";

        int equalSpaces = spaces / (totalWords - 1);
        int addOneSpaceTillIndex = (spaces % (totalWords - 1)) + start;

        StringBuilder builder = new StringBuilder();
        for(int i = start ; i <= end; i++){
            builder.append(words[i]);
            if(i != end){
                int totalSpaces = equalSpaces;
                if(i < addOneSpaceTillIndex){
                    totalSpaces ++;
                }
                for(int j = 0 ; j < totalSpaces ; j++) builder.append(" ");
            }
        }
        return builder.toString();

    }

    private String createLine(String[] words, int start, int end, int wordWidth, int maxWidth){

        int spaces = maxWidth - wordWidth;
        int totalWords = end - start + 1;
        if(totalWords == 1 || end == words.length - 1) 
            return createLastLine(words, start, end, wordWidth, maxWidth);

        return createNormalLine(words, start, end, wordWidth, maxWidth);

    }

    public List<String> fullJustify(String[] words, int maxWidth) {

        int start = 0;
        int n = words.length;
        List<String> ans = new ArrayList<>();

        while(start < n){
            int wordWidth = words[start].length();
            int spaces = 0;
            int totalWidth = wordWidth + spaces;
            int end = start;
            while(end + 1 < n && (totalWidth + minSpace +  words[end + 1].length()) <= maxWidth){
                end = end + 1;
                wordWidth += words[end].length();
                spaces += minSpace;
                totalWidth = wordWidth + spaces;
            }

            String s = createLine(words, start, end, wordWidth, maxWidth);
            ans.add(s);
            start = end + 1;
        }
        return ans;
    }
}