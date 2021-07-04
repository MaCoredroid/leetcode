class WordDictionary {
    Node root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root=new Node();
    }
    
    public void addWord(String word) {
        Node cur=root;
        for(char ch:word.toCharArray()){
            if(cur.nodes[ch-'a']==null){
                cur.nodes[ch-'a']=new Node();
            }
            cur=cur.nodes[ch-'a'];
        }
        cur.flag=true;
    }
    
    public boolean search(String word) {
        return searchHelper(root,word.toCharArray(),0);
    }
    
    private boolean searchHelper(Node root,char[] ch,int i){
        if(i==ch.length){
            return root.flag;
        }
        if(ch[i]=='.'){
            for(int j=0;j<26;j++){
                if(root.nodes[j]!=null){
                    if(searchHelper(root.nodes[j],ch,i+1)){
                        return true;
                    }
                }
            }
            return false;
        }else{
            if(root.nodes[ch[i]-'a']==null){
                return false;
            }
            return searchHelper(root.nodes[ch[i]-'a'],ch,i+1);
        }
    }
}

class Node{
    Node[] nodes=new Node[26];
    boolean flag=false;
    public Node(){
        
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */