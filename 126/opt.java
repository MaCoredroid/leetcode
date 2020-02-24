class Solution {
    // 返回结果
    List<List<String>> res = new ArrayList();
    // 单词字典
    Set<String> dict ;
    // dfs路线
    List<String> dfsList = new ArrayList<>();
    // 邻接矩阵
    Map<String,List<String>> map = new HashMap();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList)     {
        if(wordList==null||wordList.size()==0) return res;
        dict = new HashSet(wordList);
        // 字典中不存这个单词
        if(dict.contains(endWord)==false) return res;
        // 移除和起始单词相同的词
        if(dict.contains(beginWord)==true) dict.remove(beginWord);
        // 起始点集合，将起始点加入开始集合
        Set<String> beginSet = new HashSet();
        beginSet.add(beginWord);
        // 终点点集合，将终点加入终点集合
        Set<String> endSet = new HashSet();
        endSet.add(endWord);
        // 执行bfs搜索，完成
        bfs(beginSet,endSet,false);
        // 将路线起始点加入list
        dfsList.add(beginWord);
        // 深搜最短路
        dfs(beginWord, endWord);
        return res;

    }
    public void bfs(Set<String> start,Set<String> end,boolean reverse)
    {
        if(start.size()==0)
        {
            return ;
        }
        if(start.size()>end.size())
        {
            bfs(end,start,!reverse);
            return;
        }
        boolean finish=false;
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
                            finish=true;
                        }
                        else
                        {
                            next.add(newTemp);
                        }
                        String key = (reverse==true?newTemp:temp);
                        String value = (reverse==true?temp:newTemp);
                        List<String> list = map.getOrDefault(key,new ArrayList());
                        list.add(value);
                        map.put(key,list);
                    }
                }
                chars[i]=tmp;
            }
        }
        if(!finish)
        {
            bfs(next,end,reverse);
        }
    }
    public void dfs(String beginWord, String endWord){
        if(beginWord.equals(endWord)){
            res.add(new ArrayList(dfsList));
            return ;
        }
        // 遍历邻接点
        for(String word: map.getOrDefault(beginWord,new ArrayList<String>())){
            dfsList.add(word);
            dfs(word,endWord);
            dfsList.remove(dfsList.size()-1);
        }
    }

}