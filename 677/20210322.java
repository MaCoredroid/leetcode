class MapSum {
    Trie dummy;
    /** Initialize your data structure here. */
    public MapSum() {
        dummy=new Trie();
    }
    
    public void insert(String key, int val) {
        char[] ch=key.toCharArray();
        Trie cur=dummy;
        for(int i=0;i<ch.length;i++){
            if(cur.next[ch[i]-'a']==null){
                cur.next[ch[i]-'a']=new Trie();
            }
            cur= cur.next[ch[i]-'a'];
        }
        cur.value=val;
        
    }
    
    public int sum(String prefix) {
        char[] ch=prefix.toCharArray();
        Trie cur=dummy;
        for(int i=0;i<ch.length;i++){
            cur=cur.next[ch[i]-'a'];
            if(cur==null){
                return 0;
            }
        }
        return sumup(cur);

    }

    private int sumup(Trie cur){
        int sum=cur.value;
        for(int i=0;i<26;i++){
            if(cur.next[i]!=null){
                sum+=sumup(cur.next[i]);
            }
        }
        return sum;
    }
}

class Trie{
    Trie[] next;
    int value;
    public Trie(){
        next=new Trie[26];
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */