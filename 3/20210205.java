class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0||s.length()==1)
        {
            return s.length();
        }
        Set<Character> res= new HashSet<>();
        int begin=0;
        int end=0;
        int length=0;
        for(int i=0;i<s.length();i++)
        {
            if(res.contains(s.charAt(i)))
            {
                while(res.contains(s.charAt(i)))
                {
                    res.remove(s.charAt(begin));
                    begin++;
                }
            }
            else
            {
                length=Math.max(length,end-begin+1);
            }
            res.add(s.charAt(i));
            end++;
        }
        return length;
    }
}