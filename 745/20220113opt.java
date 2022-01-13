class WordFilter {
    TrieNode trie;
    public WordFilter(String[] words) {
        trie=new TrieNode();
        for(int w=0;w<words.length;w++){
            String word=words[w]+"{";
            for(int i=0;i<word.length();i++){
                TrieNode cur=trie;
                cur.w=w;
                for(int j=i;j<2*word.length()-1;j++){
                    int k=word.charAt(j%word.length())-'a';
                    if(cur.children[k]==null) cur.children[k]=new TrieNode();
                    cur=cur.children[k];
                    cur.w=w;
                }
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        TrieNode cur=trie;
        for(char c:(suffix+'{'+prefix).toCharArray()){
            if(cur.children[c-'a']==null) return -1;
            cur=cur.children[c-'a'];
        }
        return cur.w;
        
    }
}

class  TrieNode{
    TrieNode[] children;
    int w;
    public TrieNode(){
        children=new TrieNode[27];
        w=0;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */