class Solution {
    public int minFlips(int a, int b, int c) {
        int count=0;
        while(c>0||a>0||b>0){
            int ans=c&1;
            int num1=a&1;
            int num2=b&1;
            if(ans==1){
                if(num1==0&&num2==0){
                    count++;
                }
            }else{
                count+=num1+num2;
            }
            a=(a>>1);
            b=(b>>1);
            c=(c>>1);
        }
        return count;

    }
}