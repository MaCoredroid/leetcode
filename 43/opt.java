class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0"))
        {
            return "0";
        }
        int[] res=new int[num1.length()+num2.length()];
        for(int i=num1.length()-1;i>=0;i--)
        {
            int a=num1.charAt(i)-'0';
            for(int j=num2.length()-1;j>=0;j--)
            {
                int b=num2.charAt(j)-'0';
                int ans=res[i+j+1]+a*b;
                res[i+j]+=ans/10;
                res[i+j+1]=ans%10;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int p=0;p<res.length;p++)
        {
            if(p==0&&res[p]==0)
            {
                continue;
            }
            sb.append(res[p]);
        }
        return sb.toString();
    }
}