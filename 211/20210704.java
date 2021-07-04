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
    
    private boolean searchHelper(Node root,char[] ch,int start){
        Node cur=root;
        for(int i=start;i<ch.length;i++){
            if(ch[i]=='.'){
                for(int j=0;j<26;j++){
                    if(cur.nodes[j]!=null){
                        if(searchHelper(cur.nodes[j],ch,i+1)){
                            return true;
                        }
                    }
                }
                return false;
            }else{
                if(cur.nodes[ch[i]-'a']==null){
                    return false;
                }
                cur=cur.nodes[ch[i]-'a'];
            }
        }
        return cur.flag;
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