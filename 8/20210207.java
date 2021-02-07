class Solution {
    public int myAtoi(String s) {
        int index=0;
        while(index<s.length()&&s.charAt(index)==' ')
        {
            index++;
        }
        if(index==s.length())
        {
            return 0;
        }
        int sign=1;
        if(s.charAt(index)=='+')
        {
            index++;
        }
        else if(s.charAt(index)=='-')
        {
            sign=-1;
            index++;
        }
        int ret=0;
        while(index<s.length())
        {
            if(s.charAt(index)>='0'&&s.charAt(index)<='9'){
                if(ret>Integer.MAX_VALUE/10||(ret==Integer.MAX_VALUE/10&&(s.charAt(index)-'0')>7))
                {
                    return Integer.MAX_VALUE;
                }
                if(ret<Integer.MIN_VALUE/10||(ret==Integer.MIN_VALUE/10&&(s.charAt(index)-'0')>8))
                {
                    return Integer.MIN_VALUE;
                }
            }
            else{
                break;
            }
            ret*=10;
            ret+=sign*(s.charAt(index)-'0');
            index++;
        }
        return ret;
    }
}