class Solution {
    public String addStrings(String num1, String num2) {
        char[] ch1=num1.toCharArray();
        char[] ch2=num2.toCharArray();
        char[] ch=new char[1+Math.max(ch1.length,ch2.length)];
        int index1=ch1.length-1,index2=ch2.length-1,index=ch.length-1;
        int overflow=0;
        while(index1>=0||index2>=0||overflow>0){
            int addition1=index1<0?0:ch1[index1--]-'0';
            int addition2=index2<0?0:ch2[index2--]-'0';
            int res=addition1+addition2+overflow;
            if(res>=10){
                overflow=1;
                res-=10;
            }else{
                overflow=0;
            }
            ch[index--]=(char)(res+'0');
        }
        if(ch[0]==0){
            return new String(ch,1,ch.length-1);
        }
        return new String(ch);
        
    }
}