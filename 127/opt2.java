class Solution {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> start=new HashSet();
        HashSet<String> end=new HashSet();
        start.add(beginWord);
        end.add(endWord);
        HashSet<String> dict=new HashSet<>(wordList);
        if(!dict.contains(endWord))
        {
            return 0;
        }
        return bfs(start,end,dict,2);
    }
    public int bfs(HashSet<String> start,HashSet<String> end,HashSet<String> dict,int num)
    {
        if(start.size()==0)
        {
            return 0;
        }
        if(start.size()>end.size())
        {
            return bfs(end,start,dict,num);
        }
        dict.removeAll(start);
        HashSet<String> next=new HashSet();
        for(String temp:start)
        {
            char[] chars=temp.toCharArray();
            for(int i=0;i<chars.length;i++)
            {
                char tmp=chars[i];
                for(char c='a';c<='z';c++)
                {
                    if(tmp==c)
                    {
                        continue;
                    }
                    chars[i]=c;
                    String newTemp= new String(chars);
                    if(dict.contains(newTemp))
                    {
                        if(end.contains(newTemp))
                        {
                            return num;
                        }
                        else
                        {
                            next.add(newTemp);
                        }
                        
                    }
                }
                chars[i]=tmp;
            }
        }
        return bfs(next,end,dict,num+1);
    }
}