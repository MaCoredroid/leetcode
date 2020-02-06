class Solution {
    public int strStr(String haystack, String needle) {
        int size=needle.length();
        if(size==0)
        {
            return 0;
        }
        for(int i=0;i+size<=haystack.length();i++)
        {
            if(needle.equals(haystack.substring(i,i+size)))
            {
                return i;
            }
        }
        return -1;
    }
}