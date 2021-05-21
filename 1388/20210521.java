class Solution {
    public int maxSizeSlices(int[] slices) {
        int[] ans1=new int[slices.length-1];
        int[] ans2=new int[slices.length-1];
        System.arraycopy(slices,1,ans1,0,slices.length-1);
        System.arraycopy(slices,0,ans2,0,slices.length-1);
        return Math.max(calculate(ans1),calculate(ans2));
    }

    public int calculate(int[] slices){
        int n=slices.length;
        int num=(n+1)/3;
        int[][] dp=new int[n+1][num+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=num;j++){
                dp[i][j]=Math.max((i-2>=0?dp[i-2][j-1]:0)+slices[i-1],dp[i-1][j]);
            }
        }
        return dp[n][num];

    }
}