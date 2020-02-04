class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return dfs(dp,s,wordDict,s.length()-1);
    }
    private boolean dfs(int[] dp,String s,List<String> wordDict,int idx)
    {
        if(s.isEmpty())
        {
            return true;
        }
        if(idx<0)
        {
            return true;
        }
        if(dp[idx]!=-1)
        {
            if(dp[idx]==1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        boolean isValid=false;
        for(String t:wordDict)
        {
            if(t.length()>idx+1)
            {
                continue;
            }
            String cut=s.substring(idx-t.length()+1,idx+1);
            if(cut.equals(t))
            {
                if(dfs(dp,s,wordDict,idx-t.length()))
                {
                    isValid=true;
                    break;
                }
            }
        }
        if(isValid)
        {
            dp[idx]=1;
        }
        else
        {
            dp[idx]=0;
        }
        return isValid;
    }
}