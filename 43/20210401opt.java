class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        int[] ans=new int[num1.length()+num2.length()];
        for(int i=0;i<num1.length();i++){
            for(int j=0;j<num2.length();j++){
                ans[i+j+1]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }
        for(int i=num1.length()+num2.length()-1;i>0;i--){
            ans[i-1]+=ans[i]/10;
            ans[i]%=10;
        }
        StringBuilder sb=new StringBuilder();
        int index = ans[0] == 0 ? 1 : 0;
        while(index<ans.length){
            sb.append(ans[index++]);
        }
        return sb.toString();
        

    }
}