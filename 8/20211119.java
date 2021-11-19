class Solution {
    public int myAtoi(String s) {
        char[] ch=s.toCharArray();
        int p=0,ans=0,sign=1;
        while(p<ch.length&&ch[p]==' '){
            p++;
        }
        if(p<ch.length&&(ch[p]=='-'||ch[p]=='+')){
            sign=ch[p]=='-'?-1:1;
            p++;
        }
        while(p<ch.length){
            if(ch[p]>='0'&&ch[p]<='9'){
                if(sign==1&&(ans>Integer.MAX_VALUE/10||(ans==Integer.MAX_VALUE/10&&ch[p]>'7'))){
                    return Integer.MAX_VALUE;
                }else if(sign==-1&&(ans*sign<Integer.MIN_VALUE/10||(ans*sign==Integer.MIN_VALUE/10&&ch[p]>'8'))){
                    return Integer.MIN_VALUE;
                }
                ans=ans*10+ch[p++]-'0';
            }else{
                break;
            }
        }
        return sign*ans;
    }
}