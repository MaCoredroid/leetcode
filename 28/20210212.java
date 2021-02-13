class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0)
        {
            return 0;
        }
        for(int i=0;i<=haystack.length()-needle.length();i++)
        {
            for(int j=0;j<needle.length();j++)
            {
                if(haystack.charAt(j+i)!=needle.charAt(j))
                {
                    break;
                }
                if(j==needle.length()-1)
                {
                    return i;
                }
            }
        }
        return -1;
    }
}