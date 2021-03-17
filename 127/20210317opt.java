class Solution {
   
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet= new HashSet<>(wordList);
        Set<String> beginSet= new HashSet<>();
        Set<String> visited=new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);
        beginSet.add(beginWord);
        int step=1;
        if(!wordSet.contains(endWord)){
            return 0;
        }
        Set<String> endSet=new HashSet<>();
        endSet.add(endWord);
        while(!beginSet.isEmpty()&&!endSet.isEmpty()){
            step++;
            if(beginSet.size()>endSet.size()){
                Set<String> temp=new HashSet<>();
                temp=beginSet;
                beginSet=endSet;
                endSet=temp;
            }
            Set<String> newBeginSet=new HashSet<>();
            if(exchange(visited,newBeginSet,beginSet,endSet,wordSet)){
                return step;
            }
            beginSet=newBeginSet;


        }
        return 0;
    }

    private boolean exchange(Set<String> visited,Set<String> newBeginSet,Set<String> beginSet,Set<String> endSet,Set<String> wordSet){
        for(String word:beginSet){
            char[] ch=word.toCharArray();
            for(int i=0;i<ch.length;i++){
                char tmp=ch[i];
                for(int j=0;j<26;j++){
                    if(tmp=='a'+j){
                        continue;
                    }
                    ch[i]=(char)('a'+j);
                    String newWord=new String(ch);
                    if(!wordSet.contains(newWord)){
                        continue;
                    }
                    if(endSet.contains(newWord)){
                        return true;
                    }
                    if(visited.contains(newWord)){
                        continue;
                    }
                    newBeginSet.add(newWord);
                    visited.add(newWord);
                }
                ch[i]=tmp;
            }
        }
        return false;
    }

    
}