class Solution {
    public boolean isMatch(String s, String p) {
        int i=s.length();
        int j=p.length();
        boolean[][] dp= new boolean[i+1][j+1];
        dp[0][0]=true;
        for(int m=0;m<=i;m++)
        {
            for(int n=1;n<=j;n++)
            {
                if(p.charAt(n-1)=='*')
                {
                    if(match(s,p,m,n-1))
                    {
                        dp[m][n]=dp[m][n]||dp[m][n-2]||dp[m-1][n];
                    }
                    else
                    {
                        dp[m][n]=dp[m][n]||dp[m][n-2];
                    }
                }
                else
                {
                    if(match(s,p,m,n))
                    {
                        dp[m][n]=dp[m-1][n-1];
                    }
                }
            }
        }
        return dp[i][j];
    }
    private boolean match(String s ,String p ,int i,int j)
    {
        if(i==0)
        {
            return false;
        }
        if(p.charAt(j-1)=='.')
        {
            return true;
        }
        if(s.charAt(i-1)==p.charAt(j-1))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}