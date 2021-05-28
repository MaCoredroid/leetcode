class Solution {
    public int minInsertions(String s) {
        char[] ch1=s.toCharArray();
        char[] ch2=new char[ch1.length];
        for(int i=0;i<ch1.length;i++){
            ch2[i]=ch1[ch1.length-1-i];
        }
        int[][] dp=new int[ch1.length+1][ch2.length+1];
        for(int i=1;i<=ch1.length;i++){
            for(int j=1;j<=ch2.length;j++){
                if(ch1[i-1]==ch2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return ch1.length-dp[ch1.length][ch2.length];
    }
}