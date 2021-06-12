class Solution {
    int NINF = Integer.MIN_VALUE / 3;
    Integer[][] memo;
    public int tallestBillboard(int[] rods) {
        int N=rods.length;
        memo = new Integer[N][10001];
        return (int) dfs(rods, 0, 5000);
    }

    private int dfs(int[] rods, int i, int s){
        if(i==rods.length){
            return s==5000?0:NINF;
        }else if(memo[i][s]!=null){
            return memo[i][s];
        }else{
            int ans=dfs(rods,i+1,s);
            ans=Math.max(ans,rods[i]+dfs(rods,i+1,s-rods[i]));
            ans=Math.max(ans,dfs(rods,i+1,s+rods[i]));
            memo[i][s]=ans;
            return ans;
        }
    }
}