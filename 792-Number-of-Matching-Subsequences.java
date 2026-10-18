class Solution {

    public class Node{
        public int index;
        public String word;

        public Node(int index, String word){
            this.index = index;
            this.word = word;
        }
        public Node(String word){
            this.index = 0;
            this.word = word;
        }
    }

    public int numMatchingSubseq(String s, String[] words) {

        int count = 0;

        Deque<Node>[] buckets = new ArrayDeque[26];
        for(int i = 0 ; i < 26 ; i++){
            buckets[i] = new ArrayDeque<>();
        }
        for(String word : words){
            buckets[word.charAt(0) - 'a'].add(new Node(word));
        }
        

        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            Deque<Node> queue = buckets[c - 'a'];
            int size = queue.size();

            for(int j = 0 ; j < size ; j++){
                Node node = queue.pollFirst();
                node.index++;

                if(node.index == node.word.length()) {  count++;    }
                else {
                    char to = node.word.charAt(node.index);
                    buckets[to - 'a'].add(node);
                }
            }    
        }

        
        return count;
    }
}