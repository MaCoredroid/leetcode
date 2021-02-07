class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        String ans="";
        for(int len=0;len<n;len++)
        {
            for(int start=0;start+len<n;start++)
            {
                int end=start+len;
                if(len==0)
                {
                    dp[start][end]=true;
                }
                else if(len==1)
                {
                    dp[start][end]=(s.charAt(start)==s.charAt(end))?true:false;
                }
                else
                {
                    dp[start][end]=(s.charAt(start)==s.charAt(end)&&dp[start+1][end-1])?true:false;
                }
                if(dp[start][end]&&end-start+1>ans.length())
                {
                    ans=s.substring(start,end+1);
                }
            }
        }
        return ans;
    }
}