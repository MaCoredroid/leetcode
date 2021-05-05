class Solution {
    public int minCut(String s) {
        boolean[][] dp=new boolean[s.length()][s.length()];
        for(boolean[] line:dp){
            Arrays.fill(line,true);
        }
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1];
                }else{
                    dp[i][j]=false;
                }
            }
        }
        int[] ans=new int[s.length()];
        Arrays.fill(ans,Integer.MAX_VALUE);
        for(int i=0;i<s.length();i++){
            if(dp[0][i]){
                ans[i]=0;
            }else{
                for(int j=0;j<i;j++){
                    if(dp[j+1][i]){
                        ans[i]=Math.min(ans[i],ans[j]+1);
                    }
                }
            }
        }
        return ans[ans.length-1];

    }
}