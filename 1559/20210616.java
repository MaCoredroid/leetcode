class Solution {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(m * n);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i > 0 && grid[i][j] == grid[i - 1][j]) {
                    if (!uf.union(i * n + j, (i - 1) * n + j)) {
                        return true;
                    }
                }
                if (j > 0 && grid[i][j] == grid[i][j - 1]) {
                    if (!uf.union(i * n + j, i * n + j - 1)) {
                        return true;
                    }
                }
            }
        }
        return false;

    }
}

class UnionFind{
    int[] parents;
    int[] weights;
    public UnionFind(int n){
        parents=new int[n];
        for(int i=0;i<parents.length;i++){
            parents[i]=i;
        }
        weights=new int[n];
    }

    public int find(int a){
        if(a!=parents[a]){
            parents[a]=find(parents[a]);
        }
        return parents[a];
    }

    public boolean union(int a,int b){
        int rootA=find(a);
        int rootB=find(b);
        if(rootA==rootB){
            return false;
        }
        if(weights[rootA]==weights[rootB]){
            weights[rootA]++;
            parents[rootB]=rootA;
        }else if(weights[rootA]>weights[rootB]){
            parents[rootB]=rootA;
        }else{
            parents[rootA]=rootB;
        }
        return true;
    }
}