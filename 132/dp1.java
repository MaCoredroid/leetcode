class Solution {
    public int minCut(String s) {
        int[] dp= new int[s.length()+1];
        for(int i=1;i<s.length();i++)
        {
            String temp=s.substring(0,i+1);
            if(isPalindrome(temp))
            {
                dp[i]=0;
            }
            else
            {
                dp[i]=Integer.MAX_VALUE;
                for(int p=1;p<=i;p++)
                {
                    if(isPalindrome(s.substring(p,temp.length())))
                    {
                        if(dp[i]>1+dp[p-1])
                        {
                            dp[i]=1+dp[p-1];
                        }
                    }
                }
            }
        }
        return dp[s.length()-1];
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