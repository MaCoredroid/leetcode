class Solution {
    private boolean[] visit;// visit[v2]=true表示点v2访问过
    private int[] link;// link[v2]=v1表示当前与v2相连的点是v1
    // 其中v1属于点集V1，v2属于点集V2，数组下标从0开始

    private boolean[][] board;// 棋盘，false表示坏的
    private int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

    public int domino(int n, int m, int[][] broken) {
        
        if(broken.length==0){
            return n*m>>1;
        }
        board=new boolean[n][m];
        for(int[] b:broken){
            board[b[0]][b[1]]=true;
        }
        
        visit=new boolean[n*m];
        link=new int[n*m];
        Arrays.fill(link,-1);
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!board[i][j]&&(i+j)%2==0){
                    Arrays.fill(visit,false);
                    if(dfs(i,j)){
                        res++;
                    }
                }
            }
        }
        return res;
    }

    private boolean dfs(int i,int j){
        int n = board.length, m = board[0].length;
        for(int p=0;p<4;p++){
            int nx=i+dir[p][0];
            int ny=j+dir[p][1];
            if(nx<0||nx>=n||ny<0||ny>=m){
                continue;
            }
            if(!board[nx][ny]&&!visit[nx*m+ny]){
                visit[nx*m+ny]=true;
                if(link[nx*m+ny]==-1||dfs(link[nx*m+ny]/m,link[nx*m+ny]%m)){
                    link[nx*m+ny]=i*m+j;
                    return true;
                }
            }
        }
        return false;
    }
}