class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger>=desiredTotal){
            return true;
        }
        if((1+maxChoosableInteger)*maxChoosableInteger/2<desiredTotal){
            return false;
        }
        return dfs(0,desiredTotal,new Boolean[1<<maxChoosableInteger],maxChoosableInteger);
    }

    private boolean dfs(int state, int desiredTotal,Boolean[] dp, int maxChoosableInteger){
        if(dp[state]!=null){
            return dp[state];
        }
        for(int i=1;i<=maxChoosableInteger;i++){
            if((state&(1<<(i-1)))!=0){
                continue;
            }
            if(i>=desiredTotal||!dfs(state|(1<<(i-1)),desiredTotal-i,dp,maxChoosableInteger)){
                return dp[state]=true;
            }
        }
        return dp[state]=false;
    }
}