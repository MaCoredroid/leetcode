class WordDictionary {
    Node root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root=new Node();
    }
    
    public void addWord(String word) {
        Node cur=root;
        for(char ch:word.toCharArray()){
            if(cur.next[ch-'a']==null){
                cur.next[ch-'a']=new Node();
            }
            cur=cur.next[ch-'a'];
        }
        cur.flag=true;
    }
    
    public boolean search(String word) {
        Node cur=root;
        return helper(word.toCharArray(),0,cur);
    }

    private boolean helper(char[] ch,int start,Node node){
        if(start==ch.length){
            return node.flag;
        }
        if(ch[start]=='.'){
            for(int i=0;i<26;i++){
                if(node.next[i]!=null&&helper(ch,start+1,node.next[i])){
                    return true;
                }
            }
            return false;
        }else{
            if(node.next[ch[start]-'a']==null){
                return false;
            }
            return helper(ch,start+1,node.next[ch[start]-'a']);
        }

    }
}

class Node{
    Node[] next;
    boolean flag;
    public Node(){
        this.next=new Node[26];
        this.flag=false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */