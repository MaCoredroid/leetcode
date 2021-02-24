class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0||s.length()==1)
        {
            return s.length();
        }
        int[] res=new int[128];
        for(int i=0;i<128;i++)
        {
            res[i]=-1;
        }
        int ret=0;
        int start=-1;
        for(int i=0;i<s.length();i++)
        {
            start=Math.max(start,res[s.charAt(i)]);
            ret=Math.max(ret,i-start);
            res[s.charAt(i)]=i;
        }
        return ret;
    }
}