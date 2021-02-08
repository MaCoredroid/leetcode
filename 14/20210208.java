class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
        {
            return "";
        }
        String origin=strs[0];
        for(int i=1; i<strs.length;i++)
        {
            origin=longestCommon(origin,strs[i]);
            if(origin=="")
            {
                return "";
            }
        }
        return origin;
        
    }
    public String longestCommon(String a,String b){
        int index=0;
        while(index<a.length()&&index<b.length()&&a.charAt(index)==b.charAt(index))
        {
            index++;
        }
        return a.substring(0,index);
    }
}