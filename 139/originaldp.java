class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String,Boolean> map=new HashMap<>();
        for(String string:wordDict)
        {
            map.put(string,true);
        }
        boolean[] dp= new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++)
        {
            String temp=s.substring(0,i);
            if(map.containsKey(temp))
            {
                dp[i]=true;
            }
            else
            {
                for(int p=0;p<temp.length();p++)
                {
                    if(dp[p]&&map.containsKey(temp.substring(p)))
                    {                        
                        dp[i]=true;
                        break;                       
                    }
                }
            }
            
        }
        return dp[s.length()];

    }
}