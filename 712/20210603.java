class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        char[] ch1=s1.toCharArray();
        char[] ch2=s2.toCharArray();
        int[][] dp=new int[ch1.length+1][ch2.length+1];
        for(int i=0;i<ch1.length;i++){
            for(int j=0;j<ch2.length;j++){
                if(ch1[i]==ch2[j]){
                    dp[i+1][j+1]=dp[i][j]+(int)ch1[i];
                }else{
                    dp[i+1][j+1]=Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        int temp=dp[ch1.length][ch2.length]*2;
        int sum=0;
        for(int i=0;i<ch1.length;i++){
            sum+=(int)(ch1[i]);
        }
        for(int i=0;i<ch2.length;i++){
            sum+=(int)(ch2[i]);
        }
        return sum-temp;

    }
}