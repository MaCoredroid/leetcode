class Solution {
    public String longestPalindrome(String s) {
        String ans="";
        for(int i=0;i<s.length();i++)
        {
            int left=i-1;
            int right=i+1;
            while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right))
            {
                left--;
                right++;
            }
            if(right-left-1>ans.length())
            {
                ans=s.substring(left+1,right);
            }
            left=i;
            right=i+1;
            while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right))
            {
                left--;
                right++;
            }
            if(right-left-1>ans.length())
            {
                ans=s.substring(left+1,right);
            }
        }
        return ans;
    }
}