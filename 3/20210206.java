class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0||s.length()==1)
        {
            return s.length();
        }
        int begin=0;
        int end=0;
        int length=0;
        int[] counter=new int[128];
        while(end<s.length())
        {
            int index=s.charAt(end);
            
            while(counter[index]!=0)
            {
                counter[s.charAt(begin)]--;
                begin++;
            }
            length=Math.max(length,end-begin+1);
            counter[index]++;
            end++;
        }
        return length;
    }
}