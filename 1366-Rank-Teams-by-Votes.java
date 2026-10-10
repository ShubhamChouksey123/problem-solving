class Solution {
    public String rankTeams(String[] votes) {
        
        int numTeams = votes[0].length();

        Map<Character, int[]> countMap = new HashMap<>();
        for(char c : votes[0].toCharArray()){
            countMap.put(c, new int[numTeams]);
        }

        for(String vote : votes){
            for(int i = 0 ; i < numTeams ; i++){
                char team = vote.charAt(i);
                countMap.get(team)[i]++;
            }
        }
        
        List<Character> teams = new ArrayList<>(countMap.keySet());

        Collections.sort(teams, (a, b) -> {
            for(int i = 0 ; i < numTeams ; i++){
                if(countMap.get(a)[i] != countMap.get(b)[i]){
                    return Integer.compare(countMap.get(b)[i], countMap.get(a)[i]);
                }
            }
            return Character.compare(a, b);
        });


        StringBuilder builder = new StringBuilder();
        for(char c : teams){
            builder.append(c);
        }
        return builder.toString();
    }   
}