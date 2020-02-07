class Solution {
    public String minWindow(String s, String t) {
        int start=-1;
        int left=0;
        int right=0;
        int found=0;
        int[] count=new int[128];
        for(int i=0;i<t.length();i++)
        {
            count[t.charAt(i)]++;
        }
        int minlen=s.length()+1;
        while(right<s.length())
        {
            if(count[s.charAt(right)]>0)
            {
                found++;
            }
            count[s.charAt(right)]--;
            right++;
            while(found==t.length())
            {
                if(minlen>right-left)
                {
                    minlen=right-left;
                    start=left;
                }
                if(count[s.charAt(left)]==0)
                {
                    found--;
                }
                count[s.charAt(left)]++;
                left++;
            }
        }
        if(start==-1)
        {
            return "";
        }
        return s.substring(start, start + minlen);
    }
}