class Solution {
    long[] memo;
    public long mostPoints(int[][] questions) {
        int n=questions.length;
        memo=new long[n];
        return dfs(questions,0);
    }
    
    public long dfs(int[][] questions,int p){
        if(p>=questions.length) return 0;
        if(memo[p]>0) return memo[p];
        long ans=Math.max(questions[p][0]+dfs(questions,p+questions[p][1]+1),dfs(questions,p+1));
        memo[p]=ans;
        return ans;
    }
}