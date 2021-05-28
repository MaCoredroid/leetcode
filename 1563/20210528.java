class Solution {
    int[][] f;
    int[] pre;
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;
        f=new int[n][n];
        pre=new int[stoneValue.length+1];
        for(int i=1;i<=stoneValue.length;i++){
            pre[i]=pre[i-1]+stoneValue[i-1];
        }
        return dfs(stoneValue,0,stoneValue.length-1);
    }

    private int dfs(int[] stoneValue,int left,int right){
        if (left == right) {
            return 0;
        }
        if (f[left][right] != 0) {
            return f[left][right];
        }
        for(int i=left+1;i<=right;i++){
            int sum1=pre[i]-pre[left];
            int sum2=pre[right+1]-pre[i];
            if(sum1>sum2){
                f[left][right]=Math.max(f[left][right],sum2+dfs(stoneValue,i,right));
            }else if(sum1<sum2){
                f[left][right]=Math.max(f[left][right],sum1+dfs(stoneValue,left,i-1));
            }else{
                f[left][right]=Math.max(f[left][right],Math.max(sum1+dfs(stoneValue,left,i-1),sum2+dfs(stoneValue,i,right)));
            }
        }
        return f[left][right];
    }
}