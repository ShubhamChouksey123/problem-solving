class Trie {

    public class Node {

        public boolean end;
        public Node[] branch;

        public Node(){
            this.end = false;
            this.branch = new Node[26];
        }
        
    }

    private Node root;

    public Trie() {
        root = new Node(); 
    }
    
    public void insert(String word) {
        
        Node node = root;
        for(char c : word.toCharArray()){
            if(node.branch[c-'a'] == null){
                node.branch[c-'a'] = new Node();
            }
            node = node.branch[c-'a'];
        }
        node.end = true;
    }
    
    public boolean search(String word) {
        Node node = find(word);

        return (node != null && node.end == true);   
    }
    
    public boolean startsWith(String prefix) {
        
        Node node = find(prefix);
        return node != null;
    }

    public Node find(String prefix) {
        
        Node node = root;
        for(char c : prefix.toCharArray()){
            if(node.branch[c-'a'] == null){
                return null;
            }
            node = node.branch[c-'a'];
        }
        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */