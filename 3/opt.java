class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0||s.length()==1)
        {
            return s.length();
        }
        int fast=0;
        int slow=0;
        int count=1;
        Set<Character> occ = new HashSet<Character>();
        occ.add(s.charAt(0));
        while(slow<s.length()&&fast<s.length())
        {
            while(fast+1<s.length()&&!occ.contains(s.charAt(fast+1)))
            {
                occ.add(s.charAt(fast+1));
                fast++;
            }
            count=count>fast-slow+1?count:fast-slow+1;
            occ.remove(s.charAt(slow));
            slow++;
        }
        return count;
    }
}