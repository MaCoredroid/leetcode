class Solution {
    public int countSubstrings(String s) {
        char[] ch=s.toCharArray();
        int cnt=0;
        boolean[][] dp=new boolean[ch.length][ch.length];
        for(int i=ch.length-1;i>=0;i--){
            for(int j=i;j<ch.length;j++){
                if(i==j){
                    dp[i][j]=true;
                    cnt++;
                }else if(ch[i]==ch[j]&&(i+1>=j-1||dp[i+1][j-1])){
                    dp[i][j]=true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}