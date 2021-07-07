class Solution {
    List<String> ans=new ArrayList<>();
    Trie root=new Trie();
    public List<String> wordBreak(String s, List<String> wordDict) {
        for(String word:wordDict){
            Trie cur=root;
            for(char c:word.toCharArray()){
                if(cur.next[c-'a']==null){
                    cur.next[c-'a']=new Trie();
                }
                cur=cur.next[c-'a'];
            }
            cur.flag=true;
        }
        backTrack(new StringBuilder(),s.toCharArray(),0);
        return ans;
    }
    
    private void backTrack(StringBuilder sb, char[] ch,int index){
        int origin=sb.length();
        if(index==ch.length){
            ans.add(sb.toString());
            return;
        }
        Trie cur=root;
        for(int i=index;i<ch.length;i++){
            if(cur.next[ch[i]-'a']==null){
                return;
            }
            cur=cur.next[ch[i]-'a'];
            if(cur.flag){
                if(sb.length()!=0){
                    sb.append(" ");
                }
                sb.append(new String(ch,index,i-index+1));
                backTrack(sb,ch,i+1);
                sb=new StringBuilder(sb.substring(0,origin));
            }
        }
        
    }
    
    private static class Trie{
        Trie[] next;
        boolean flag;
        public Trie(){
            this.next=new Trie[26];
            this.flag=false;
        }
    }
}