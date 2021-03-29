class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for(int i=0;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
                if(p.charAt(j-1)=='*'){
                    if(match(s,p,i,j-1)){
                        dp[i][j]=dp[i][j-2]||dp[i-1][j];
                    }else{
                        dp[i][j]=dp[i][j-2];
                    }
                }else{
                    if(match(s,p,i,j)){
                        dp[i][j]=dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    private boolean match(String s, String p,int a, int b){
        if(a==0){
            return false;
        }
        if(p.charAt(b-1)=='.'){
            return true;
        }
        return s.charAt(a-1)==p.charAt(b-1);
    }
}