class Solution {
    List<List<String>> res=new ArrayList();
    public List<List<String>> partition(String s) {
        boolean[][] dp=new boolean[s.length()][s.length()];
        for(int right=0;right<s.length();right++)
        {
            for(int left=0;left<=right;left++)
            {
                if(s.charAt(left)==s.charAt(right)&&(right-left<=2||dp[left+1][right-1]))
                {
                    dp[left][right]=true;
                }
            }
        }
        LinkedList<String> path=new LinkedList();
        backTrack(new LinkedList(),dp,s,s.length(),0);
        return res;


    }
    public void backTrack(LinkedList<String> path,boolean[][] dp,String s,int len,int start)
    {
        if(len==start)
        {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<len;i++)
        {
            if(!dp[start][i])
            {
                continue;
            }
            path.add(s.substring(start,i+1));
            backTrack(path,dp,s,len,i+1);
            path.removeLast();
        }
    }
}