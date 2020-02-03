class Solution {
    public int minCut(String s) {
        int[] dp= new int[s.length()+1];
        boolean[][] isPalindrome= new boolean[s.length()][s.length()];
        for(int right=0;right<s.length();right++)
        {
            for(int left=0;left<=right;left++)
            {
                if(s.charAt(left)==s.charAt(right)&&(right-left<=2||isPalindrome[left+1][right-1]))
                {
                    isPalindrome[left][right]=true;
                }
            }
        }
        for(int i=1;i<s.length();i++)
        {
            String temp=s.substring(0,i+1);
            if(isPalindrome[0][i])
            {
                dp[i]=0;
            }
            else
            {
                dp[i]=Integer.MAX_VALUE;
                for(int p=1;p<=i;p++)
                {
                    if(isPalindrome[p][i])
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
    
}