class Solution {
    public String longestPalindrome(String s) {
        int ans=0;
        String ret="";
        for(int i=0;i<s.length();i++)
        {
            int start=i;
            int end=i;
            while(start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end))
            {
                start--;
                end++;
                
            }
            if(end-start>ans)
            {
                ans=end-start;
                ret=s.substring(start+1,end);
            }
            start=i;
            end=i+1;
            while(start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end))
            {
                start--;
                end++;
            }
            if(end-start>ans)
            {
                ans=end-start;
                ret=s.substring(start+1,end);
            }
        }
        return ret;
    }
}