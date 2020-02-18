class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length=beginWord.length();
        HashMap<String,ArrayList<String>> map=new HashMap<String, ArrayList<String>>();
        for(String temp:wordList)
        {
            for(int i=0;i<length;i++)
            {
                String newWord=temp.substring(0,i)+'*'+temp.substring(i+1,length);
                ArrayList<String> transformations= map.getOrDefault(newWord,new ArrayList<String>());
                transformations.add(temp);
                map.put(newWord,transformations);
            }
        }
        Queue<Pair<String,Integer>> res =new LinkedList<Pair<String,Integer>>();
        res.add(new Pair(beginWord,1));
        HashSet<String> visited=new HashSet<String>();
        visited.add(beginWord);
        while(!res.isEmpty())
        {
            Pair<String,Integer> pair=res.remove();
            String key=pair.getKey();
            int value=pair.getValue();
            for(int i=0;i<length;i++)
            {
                String newKey= key.substring(0,i)+'*'+key.substring(i+1,length);
                ArrayList<String> connected=map.getOrDefault(newKey,new ArrayList());
                for(String temp:connected)
                {
                    if(temp.equals(endWord))
                    {
                        return value+1;
                    }
                    if(!visited.contains(temp))
                    {
                        visited.add(temp);
                        res.add(new Pair(temp,value+1));
                    }
                }
            }
        }
        return 0;
    }
}