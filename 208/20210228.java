class Trie {
    Node head;
    /** Initialize your data structure here. */
    public Trie() {
        this.head=new Node(' ');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node copy=head;
        for(int i=0;i<word.length();i++){
            char a=word.charAt(i);
            copy=copy.putChildren(a);
        }
        copy.setIsEnd();

    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node copy=head;
        for(int i=0;i<word.length();i++){
            char a=word.charAt(i);
            if(copy.containsChildren(a)){
                copy=copy.getChildren(a);
            }
            else{
                return false;
            }
        }
        return copy.getIsEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node copy=head;
        for(int i=0;i<prefix.length();i++){
            char a=prefix.charAt(i);
            if(copy.containsChildren(a)){
                copy=copy.getChildren(a);
            }
            else{
                return false;
            }
        }
        return true;
    }
}

class Node {
    private HashMap<Character,Node> children;
    private char payload;
    private boolean isEnd;
    public Node(char a){
        this.children=new HashMap<>();
        this.payload=a;
        this.isEnd=false;
    }

    public void setIsEnd(){
        this.isEnd=true;
    }
    public boolean getIsEnd(){
        return this.isEnd;
    }
    public Node getChildren(char temp){
        if(!children.containsKey(temp)){
            return null;
        }
        return children.get(temp);
    }

    public boolean containsChildren(char temp){
        return children.containsKey(temp);
    }

    public Node putChildren(char temp){
        if(children.containsKey(temp)){
            return children.get(temp);
        }
        else{
            children.put(temp,new Node(temp));
            return children.get(temp);
        }
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */