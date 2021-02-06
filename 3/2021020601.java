class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0||s.length()==1)
        {
            return s.length();
        }
        int start=0;
        int end=0;
        int length=0;
        int[] last=new int[128];
        for(int i=0;i<127;i++)
        {
            last[i]=-1;
        }
        while(end<s.length())
        {
            start=Math.max(last[s.charAt(end)]+1,start);
            length=Math.max(length,end-start+1);
            last[s.charAt(end)]=end;
            end++;
        }
        return length;
    }
}