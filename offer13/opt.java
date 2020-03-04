class Solution {
    int m,n,k;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        this.m=m;
        this.n=n;
        this.k=k;
        this.visited=new boolean[m][n];
        return helper(0,0,0,0);
    }
    public int helper(int i,int j,int sumi,int sumj)
    {
        if(i<0||i>=m||j<0||j>=n||sumi+sumj>k||visited[i][j])
        {
            return 0;
        }
        visited[i][j]=true;
        return 1+helper(i,j+1,sumi,(j+1)%10==0?sumj-8:sumj+1)+helper(i+1,j,(i+1)%10==0?sumi-8:sumi+1,sumj);
    }
}