class Solution {
     public String getHint(String secret, String guess) {
        String ans = "";

        Integer bulls = 0;

        Map<Character, Integer> mpSecret = new HashMap<>();
        Map<Character, Integer> mpGuess = new HashMap<>();
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i)) {
                Integer prevCountSecret = mpSecret.get(secret.charAt(i));
                if (prevCountSecret == null) {
                    prevCountSecret = 0;
                }
                mpSecret.put(secret.charAt(i), prevCountSecret + 1);

                Integer prevCountGuess = mpGuess.get(guess.charAt(i));
                if (prevCountGuess == null) {
                    prevCountGuess = 0;
                }
                mpGuess.put(guess.charAt(i), prevCountGuess + 1);
            } else {
                bulls++;
            }

        }


        Integer cows = 0;

        for (Map.Entry<Character, Integer> entrySecret : mpSecret.entrySet()) {
            Integer countGuess = mpGuess.get(entrySecret.getKey());
            Integer countSecret = entrySecret.getValue();

            if(countGuess == null){
                countGuess = 0;
            }

            if(countSecret == null){
                countSecret = 0;
            }
            cows += Math.min(countSecret, countGuess);
        }
        ans = ans + String.valueOf(bulls) + "A" + String.valueOf(cows) + "B";

        return ans;
    }
}