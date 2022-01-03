class Solution {
    
    List<List<String>> res=new ArrayList<>();
    Set<String> dict;
    List<String> dfsList=new ArrayList<>();
    Map<String,List<String>> map=new HashMap<>();
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(wordList==null||wordList.size()==0) return res;
        dict = new HashSet(wordList);
        if(dict.contains(endWord)==false) return res;
        if(dict.contains(beginWord)==true) dict.remove(beginWord);
        Set<String> beginSet = new HashSet();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet();
        endSet.add(endWord);
        bfs(beginSet,endSet,false);
        dfsList.add(beginWord);
        dfs(beginWord, endWord);
        return res;

    }
    
    public void bfs(Set<String> start,Set<String> end,boolean reverse){
        if(start.size()==0||end.size()==0) return;
        if(start.size()>end.size()){
            bfs(end,start,!reverse);
            return;
        }
        boolean finish=false;
        dict.removeAll(start);
        HashSet<String> next=new HashSet<String>();
        for(String temp:start){
            char[] ch=temp.toCharArray();
            for(int i=0;i<ch.length;i++){
                char chr=ch[i];
                for(char c='a';c<='z';c++){
                    if(c==chr) continue;
                    ch[i]=c;
                    String newTemp=new String(ch);
                    if(dict.contains(newTemp)){
                        if(end.contains(newTemp)) finish=true;
                        next.add(newTemp);
                        String key = (reverse==true?newTemp:temp);
                        String value = (reverse==true?temp:newTemp);
                        List<String> list = map.getOrDefault(key,new ArrayList());
                        list.add(value);
                        map.put(key,list);
                    }
                }
                ch[i]=chr;
            }
        }
        if(!finish) bfs(next,end,reverse);
    }
    
    public void dfs(String beginword, String endword){
        if(beginword.equals(endword)){
            res.add(new ArrayList<>(dfsList));
            return;
        }
        for(String next:map.getOrDefault(beginword,new ArrayList<>())){
            dfsList.add(next);
            dfs(next,endword);
            dfsList.remove(dfsList.size()-1);
        }
    }
    

}