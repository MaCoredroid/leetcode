class Solution {
    public int matrixScore(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int ans=0;
        ans+=m*(1<<(n-1));
        for(int i=1;i<n;i++){
            int cnt=0;
            for(int j=0;j<m;j++){
                if(grid[j][0]==1){
                    cnt+=1-grid[j][i];
                }else{
                    cnt+=grid[j][i];
                }
            }
            ans+=Math.max(cnt,m-cnt)*(1<<(n-i-1));
        }
        return ans;
    }
}