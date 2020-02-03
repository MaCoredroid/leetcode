class Solution {
    public int minCut(String s) {
        int[][] dp= new int[s.length()+1][s.length()+1];
        for(int i=2;i<=s.length();i++)
        {
            for(int j=0;j+i<=s.length();j++)
            {
                String temp=s.substring(j,j+i);
                if(isPalindrome(temp))
                {
                    dp[j][j+i]=0;
                }
                else
                {
                    dp[j][j+i]=dp[j][j+1]+dp[j+1][j+i]+1;
                    for(int p=2;p<i;p++)
                    {
                        if(dp[j][j+p]+dp[j+p][j+i]+1<dp[j][j+i])
                        {
                            dp[j][j+i]=dp[j][j+p]+dp[j+p][j+i]+1;
                        }
                    }
                }
            }
        }
        return dp[0][s.length()];
    }
    public boolean isPalindrome(String s)
    {
        int i=0;
        int j=s.length()-1;
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}