class Solution {
    boolean[][] covered;
    int ans=0;
    public int tilingRectangle(int n, int m) {
        covered=new boolean[n][m];
        ans=n*m;
        if(n==m){
            return 1;
        }
        dfs(n,m,0);
        return ans;
    }

    private void dfs(int n,int m,int cur){
        if(cur>=ans){
            return;
        }
        int row=-1;
        int col=-1;
        boolean flag=true;
        for(int i=0;i<n&&flag;i++){
            for(int j=0;j<m&&flag;j++){
                if(!covered[i][j]){
                    row=i;
                    col=j;
                    flag=false;
                    break;
                }
            }
        }
        if(row==-1&&col==-1){
            ans=Math.min(ans,cur);
            return;
        }
        for(int len=Math.min(n-row,m-col);len>=1;len--){
            boolean isEmpty=true;
            for(int i=row;i<row+len&&isEmpty;i++){
                for(int j=col;j<col+len&&isEmpty;j++){
                    if(covered[i][j]){
                        isEmpty=false;
                        break;
                    }
                }
            }
            if(!isEmpty){
                continue;
            }
            for(int i=row;i<row+len;i++){
                for(int j=col;j<col+len;j++){
                    covered[i][j]=true;
                }
            }
            dfs(n,m,cur+1);
            for(int i=row;i<row+len;i++){
                for(int j=col;j<col+len;j++){
                    covered[i][j]=false;
                }
            }
        }
    }
}