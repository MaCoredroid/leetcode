class Solution {
    public int movingCount(int m, int n, int k) {
        if(k==0){
            return 1;
        }
        boolean[][] vis=new boolean[m][n];
        vis[0][0]=true;
        int ans=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0&&j==0)){
                    continue;
                }
                if(i-1>=0&&vis[i-1][j]&&getCount(i)+getCount(j)<=k){
                    vis[i][j]=true;
                    ans++;
                    continue;
                }
                if(j-1>=0&&vis[i][j-1]&&getCount(i)+getCount(j)<=k){
                    vis[i][j]=true;
                    ans++;
                    continue;
                }
            }
        }
        return ans;

    }

    private int getCount(int x){
        int ret=0;
        while(x>0){
            ret+=x%10;
            x/=10;
        }
        return ret;   
    }
}