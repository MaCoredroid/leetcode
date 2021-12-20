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
        int ans=2;
        boolean tiktok=true;
        while(!frontier1.isEmpty()&&!frontier2.isEmpty()){
            if(tiktok){
                Set<String> newF1=new HashSet<>();
                for(String s:frontier1){
                    List<String> next=generate(s);
                    for(String n:next){
                        if(frontier2.contains(n)) return ans;
                        if(dict.contains(n)){
                            newF1.add(n);
                            dict.remove(n);
                        } 
                    }
                }
                frontier1=newF1;
            }else{
                Set<String> newF2=new HashSet<>();
                for(String s:frontier2){
                    List<String> next=generate(s);
                    for(String n:next){
                        if(frontier1.contains(n)) return ans;
                        if(dict.contains(n)){
                            newF2.add(n);
                            dict.remove(n);
                        }
                    }
                }
                frontier2=newF2;
            }
            tiktok=!tiktok;
            ans++;    
        }
        return 0;
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