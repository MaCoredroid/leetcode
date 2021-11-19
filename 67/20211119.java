class Solution {
    public String addBinary(String a, String b) {
        char[] ch=new char[a.length()+b.length()+1];
        int p1=ch.length-1,p2=a.length()-1,p3=b.length()-1,overflow=0;
        while(p2>=0||p3>=0||overflow>0){
            int num2=p2>=0?a.charAt(p2--)-'0':0;
            int num3=p3>=0?b.charAt(p3--)-'0':0;
            int sum=num2+num3+overflow;
            if(sum>=2){
                overflow=1;
                sum-=2;
            }else{
                overflow=0;
            }
            ch[p1--]=(char)('0'+sum);
        }
        return new String(ch,p1+1,ch.length-p1-1);
        
    }
}