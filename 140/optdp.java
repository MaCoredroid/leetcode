class Solution {
    int maxLength=0;
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordmap=new HashSet(wordDict);
        for(int i=0;i<wordDict.size();i++)
        {
            maxLength=Math.max(maxLength,wordDict.get(i).length());
        }
        return word_Break(s,wordmap,0);
    }
    HashMap<Integer, List<String>> map = new HashMap<>();
    public List<String> word_Break(String s, Set<String> wordDict,int start)
    {
        if(map.containsKey(start))
        {
            return map.get(start);
        }
        LinkedList<String> res = new LinkedList<>();
        if(start==s.length())
        {
            res.add("");
        }
        for(int end=start+1;end<=s.length();end++)
        {
            if(end-start>maxLength)
            {
                break;
            }
            if(wordDict.contains(s.substring(start,end)))
            {
                List<String> ret=word_Break(s,wordDict,end);
                for(String l:ret)
                {
                    res.add(s.substring(start,end)+(l.equals("")?"":" ")+l);
                }
            }
        }
        map.put(start,res);
        return res;

    }
}