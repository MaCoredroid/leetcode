class Solution {
    public String longestPalindrome(String s) {
        int max=0;
        String ret="";
        for(int i=0;i<s.length();i++)
        {
            int ans=1;
            int left=i-1;
            int right=i+1;
            while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right))
            {
                ans+=2;
                left--;
                right++;
            }
            if(ans>max)
            {
                max=Math.max(ans,max);
                ret=s.substring(left+1,right);
            }
            ans=0;
            left=i;
            right=i+1;
            while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right))
            {
                ans+=2;
                left--;
                right++;
            }
            if(ans>max)
            {
                max=Math.max(ans,max);
                ret=s.substring(left+1,right);
            }


        }
        return ret;
    }
}