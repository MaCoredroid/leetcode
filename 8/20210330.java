class Solution {
    public int myAtoi(String s) {
        char[] ch=s.toCharArray();
        int i=0;
        while(i<ch.length){
            if(ch[i]=='-'||ch[i]=='+'||(ch[i]-'0'>=0&&ch[i]-'0'<=9)){
                break;
            }
            if(ch[i]!=' '){
                return 0;
            }
            i++;
        }
        if(i>=ch.length){
            return 0;
        }
        int base=1;
        if(ch[i]=='-'){
            base=-1;
            i++;
        }else if(ch[i]=='+'){
            i++;
        }
        int ans=0;   
        while(i<ch.length){
            if(ch[i]-'0'>=0&&ch[i]-'0'<=9){
                if(ans>Integer.MAX_VALUE/10||(ans==Integer.MAX_VALUE/10&&ch[i]-'0'>7)){
                    return Integer.MAX_VALUE;
                }
                if(ans<Integer.MIN_VALUE/10||(ans==Integer.MIN_VALUE/10&&ch[i]-'0'>8)){
                    return Integer.MIN_VALUE;
                }
                ans*=10;
                if(base>=0){
                    ans+=ch[i]-'0';
                }else{
                    ans-=ch[i]-'0';
                }
                i++;
            }else{
                break;
            }
        }
        return ans;

    }
}