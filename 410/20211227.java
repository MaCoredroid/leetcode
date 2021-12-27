class Solution {
    public int splitArray(int[] nums, int m) {
        int n=nums.length;
        int[][] f=new int[n+1][m+1];
        int[] pre=new int[n+1];
        for(int i=0;i<nums.length;i++){
            pre[i+1]=pre[i]+nums[i];
        }
        for(int i=0;i<=n;i++){
            Arrays.fill(f[i],Integer.MAX_VALUE);
        }
        f[0][0]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                for(int k=0;k<i;k++){
                    f[i][j]=Math.min(f[i][j],Math.max(f[k][j-1],pre[i]-pre[k]));
                }
            }
        }
        return f[n][m];
    }
}