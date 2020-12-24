class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0)
        {
            return "";
        }
        String perfix=strs[0];
        for(int i=1;i<strs.length;i++)
        {
            perfix=Common(strs[i],perfix);
            if(perfix=="")
            {
                break;
            }
        }
        return perfix;
    }
    public String Common(String str1, String str2)
    {
        int length=Math.min(str1.length(),str2.length());
        int index=0;
        for(int i=0;i<length;i++)
        {
            if(str1.charAt(i)==str2.charAt(i))
            {
                index++;
            }
            else
            {
                break;
            }
        }
        return str1.substring(0,index);
    }
}