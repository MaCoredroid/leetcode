import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    int length=0;
    HashMap<String,ArrayList<String>> map=new HashMap();
    public int visitNode(Queue<Pair<String, Integer>> Q,HashMap<String, Integer> visited,HashMap<String, Integer> othersvisited)
    {
        Pair<String,Integer> pair=Q.remove();
        String key=pair.getKey();
        int value=pair.getValue();
        for(int i=0;i<length;i++)
        {
            String newKey=key.substring(0,i)+'*'+key.substring(i+1,length);
            ArrayList<String> wordlist=map.getOrDefault(newKey,new ArrayList());
            for(String temp:wordlist)
            {
                if(othersvisited.containsKey(temp))
                {
                    return value+othersvisited.get(temp);
                }
                if(!visited.containsKey(temp))
                {
                    visited.put(temp,value+1);
                    Q.add(new Pair(temp,value+1));
                }
            }
        }
        return -1;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
        {
            return 0;
        }
        length=beginWord.length();
        for(String word:wordList)
        {
            for(int i=0;i<length;i++)
            {
                String newWord=word.substring(0,i)+'*'+word.substring(i+1,length);
                ArrayList<String> connected=map.getOrDefault(newWord,new ArrayList());
                connected.add(word);
                map.put(newWord,connected);
            }
        }
        Queue<Pair<String, Integer>> Qbegin=new LinkedList();
        Qbegin.add(new Pair(beginWord,1));
        Queue<Pair<String, Integer>> Qend=new LinkedList();
        Qend.add(new Pair(endWord,1));
        HashMap<String, Integer> beginVisited=new HashMap();
        beginVisited.put(beginWord,1);
        HashMap<String, Integer> endVisited=new HashMap();
        endVisited.put(endWord,1);
        while(!Qbegin.isEmpty()&&!Qend.isEmpty())
        {
            int ans=visitNode(Qbegin,beginVisited,endVisited);
            if(ans>-1)
            {
                return ans;
            }
            ans = visitNode(Qend,endVisited,beginVisited);
            if(ans>-1)
            {
                return ans;
            }
        }
        return 0;

    }
}