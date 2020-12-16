class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp=new boolean[s.length()][s.length()];
        String ans="";
        for(int l=0;l<s.length();l++)
        {
            for(int i=0;i+l<s.length();i++)
            {
                int j=i+l;
                if(l==0)
                {
                    dp[i][j]=true;
                }
                else if(l==1)
                {
                    dp[i][j]=(s.charAt(i)==s.charAt(j));
                }
                else
                {
                    dp[i][j]=(s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]);
                }
                if(dp[i][j]&&l+1>ans.length())
                {
                    ans=s.substring(i,i+l+1);
                }
            }
        }
        return ans;
    }
}