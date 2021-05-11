class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp =new int[m+1][n+1];
        for(String str:strs){
            int[] ans=count(str);  
            for(int i=m;i>=ans[0];i--){
                for(int j=n;j>=ans[1];j--){
                    dp[i][j]=Math.max(dp[i][j],1+dp[i-ans[0]][j-ans[1]]);
                }
            }
        }
        return dp[m][n];
    }

    private int[] count(String s){
        int[] ans=new int[2];
        for(int i=0;i<s.length();i++){
            ans[s.charAt(i)-'0']++;
        }
        return ans;
    }
}