class Solution {
    public String addStrings(String num1, String num2) {
        char[] ch1=num1.toCharArray();
        char[] ch2=num2.toCharArray();
        int pointer1=ch1.length-1;
        int pointer2=ch2.length-1;
        int overflow=0;
        StringBuilder sb=new StringBuilder();
        while(overflow!=0||pointer1>=0||pointer2>=0){
            int val1=pointer1>=0?ch1[pointer1]-'0':0;
            int val2=pointer2>=0?ch2[pointer2]-'0':0;
            int ans=val1+val2+overflow;
            if(ans>=10){
                overflow=1;
                ans-=10;
            }else{
                overflow=0;
            }
            sb.insert(0,ans);
            pointer1--;
            pointer2--;
        }
        return sb.toString();
    }
}