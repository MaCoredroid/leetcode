class Solution {
    int M = 1000000007;
    public int numDecodings(String s) {
        long[] dp = new long[s.length() + 1];
        char[] ch=s.toCharArray();
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
        for(int i=1;i<s.length();i++){
            if(ch[i]=='*'){
                dp[i+1]=9*dp[i];
                if(ch[i-1]=='1'){
                    dp[i+1]=(dp[i+1]+9*dp[i-1])%M;
                }else if(ch[i-1]=='2'){
                    dp[i+1]=(dp[i+1]+6*dp[i-1])%M;
                }else if(ch[i-1]=='*'){
                    dp[i+1]=(dp[i+1]+15*dp[i-1])%M;
                }
            }else{
                dp[i + 1] = ch[i]!= '0' ? dp[i] : 0;
                if(ch[i-1]=='1'){
                    dp[i+1]=(dp[i-1]+dp[i+1])%M;
                }else if(ch[i-1]=='2'&&ch[i]<='6'){
                    dp[i+1]=(dp[i-1]+dp[i+1])%M;
                }else if(ch[i-1]=='*'){
                    dp[i + 1] = (dp[i + 1] + (ch[i] <= '6' ? 2 : 1) * dp[i - 1]) % M;
                }
            }
            dp[i+1]%=M;
        }
        return (int)dp[s.length()];
    }
}