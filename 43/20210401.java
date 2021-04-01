class Solution {
    public String multiply(String num1, String num2) {
        if(num1.charAt(0)=='0'||num2.charAt(0)=='0'){
            return "0";
        }
        int overflow=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<num1.length()+num2.length()-1;i++){
            
            int ans=0;
            for(int pointer=0;pointer<num1.length();pointer++){
                if(i-pointer<num2.length()&&i-pointer>=0){
                    ans+=(num1.charAt(num1.length()-1-pointer)-'0')*(num2.charAt(num2.length()-1-i+pointer)-'0');
                }
            }
            
            ans+=overflow;
            overflow=ans/10;
            ans=ans%10;
            sb.insert(0,ans);
        }
        if(overflow!=0){
            sb.insert(0,overflow);
        }
        return sb.toString();

    }
}