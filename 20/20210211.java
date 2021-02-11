class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0)
        {
            return false;
        }
        int index=0;
        char[] res=new char[s.length()];
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[')
            {
                res[index]=s.charAt(i);
                index++;
            }
            else
            {
                if(index==0)
                {
                    return false;
                }
                char last=res[index-1];
                index--;
                if(s.charAt(i)==')'&&last!='(')
                {
                    return false;
                }
                else if(s.charAt(i)==']'&&last!='[')
                {
                    return false;
                }
                else if(s.charAt(i)=='}'&&last!='{')
                {
                    return false;
                }
            }
        }
        return index==0;
    }
}