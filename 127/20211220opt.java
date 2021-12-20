class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict=new HashSet<>(wordList);
        Set<String> frontier1=new HashSet<>();
        Set<String> frontier2=new HashSet<>();
        if(!dict.contains(endWord)) return 0;
        frontier1.add(beginWord);
        frontier2.add(endWord);
        dict.remove(beginWord);
        dict.remove(endWord);
        return BFS(frontier1,frontier2,dict,2);
    }
    
    public int BFS(Set<String> begin,Set<String> end,Set<String> dict,int ans){
        if(begin.size()>end.size()){
            return BFS(end,begin,dict,ans);
        }
        if(begin.size()==0) return 0;
        Set<String> newSet=new HashSet<>();
        for(String s:begin){
            List<String> next=generate(s);
            for(String n:next){
                if(end.contains(n)) return ans;
                if(dict.contains(n)){
                    newSet.add(n);
                    dict.remove(n);
                } 
            }
        }
        return BFS(newSet,end,dict,ans+1);
        
    }
    
    public List<String> generate(String s){
        List<String> ret=new ArrayList<>();
        char[] ch=s.toCharArray();
        for(int i=0;i<ch.length;i++){
            char c=ch[i];
            for(int j=0;j<26;j++){
                ch[i]=(char)('a'+j);
                if(ch[i]!=c) ret.add(new String(ch));
            }
            ch[i]=c;
        }
        return ret;
    }
}