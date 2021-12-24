class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")) return "0";
        int[] ans=new int[num1.length()+num2.length()];
        char[] ch1=num1.toCharArray();
        char[] ch2=num2.toCharArray();
        for(int i=0;i<ch1.length;i++){
            for(int j=0;j<ch2.length;j++){
                ans[i+j+1]+=(ch1[i]-'0')*(ch2[j]-'0');
            }
        }
        for(int p=ans.length-1;p>0;p--){
            ans[p-1]+=ans[p]/10;
            ans[p]%=10;
        }
        StringBuilder sb=new StringBuilder();
        int i=ans[0]==0?1:0;
        while(i<ans.length){
            sb.append(ans[i++]);
        }
        return sb.toString();
    }
}