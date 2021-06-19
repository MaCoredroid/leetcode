class Solution {
    int[][] dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}}; 
    public int swimInWater(int[][] grid) {
        int N=grid.length;
        UnionFind uf=new UnionFind(N*N);
        int[] index=new int[N*N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                index[grid[i][j]]=i*N+j;
            }
        }
        for(int i=0;i<N*N;i++){
            int x=index[i]/N;
            int y=index[i]%N;
            for(int k=0;k<4;k++){
                int nx=x+dirs[k][0];
                int ny=y+dirs[k][1];
                if(nx<0||nx>=N||ny<0||ny>=N||grid[nx][ny]>i){
                    continue;
                }
                uf.union(nx*N+ny,x*N+y);
                if(uf.isConnected(0,N*N-1)){
                    return i;
                }
            }
        }
        return -1;
    }
}

class UnionFind{
    int[] parents;
    int[] weights;

    public UnionFind(int n){
        parents=new int[n];
        for(int i=0;i<n;i++){
            parents[i]=i;
        }
        weights=new int[n];
    }

    public void union(int a, int b){
        int rootA=find(a);
        int rootB=find(b);
        if(rootA!=rootB){
            if(weights[rootA]==weights[rootB]){
                parents[rootB]=rootA;
                weights[rootA]++;
            }else if(weights[rootA]>weights[rootB]){
                parents[rootB]=rootA;
            }else{
                parents[rootA]=rootB;
            }
        }
    }

    public int find(int a){
        if(a!=parents[a]){
            parents[a]=find(parents[a]);
        }
        return parents[a];
    }

    public boolean isConnected(int a,int b){
        int rootA=find(a);
        int rootB=find(b);
        return rootA==rootB;
    }
}