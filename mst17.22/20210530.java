class Solution {
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>();
        for(String word:wordList){
            set.add(word);
        }
        if(!set.contains(endWord)){
            return new ArrayList<>();
        }
        Queue<List<String>> queue=new LinkedList<>();
        List<String> ret=new ArrayList<>();
        ret.add(beginWord);
        queue.offer(ret);
        while(!queue.isEmpty()){
            List<String> temp=queue.poll();
            String target=temp.get(temp.size()-1);
            char[] ch=target.toCharArray();
            for(int i=0;i<ch.length;i++){
                char origin=ch[i];
                for(int j=0;j<26;j++){
                    char replace=(char)('a'+j);
                    if(replace!=origin){
                        ch[i]=replace;
                        if(set.contains(new String(ch))){
                            String toAdd=new String(ch);
                            set.remove(toAdd);
                            temp.add(toAdd);
                            if(toAdd.equals(endWord)){
                                return temp;
                            }
                            queue.offer(new ArrayList<>(temp));
                            temp.remove(temp.size()-1);
                        }
                    }
                }
                ch[i]=origin;
            }
        }
        return new ArrayList<>();
    }
}