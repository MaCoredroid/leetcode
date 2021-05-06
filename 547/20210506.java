class Solution {
    public int findCircleNum(int[][] isConnected) {
        UnionFind uf=new UnionFind(isConnected.length);
        for(int i=0;i<isConnected.length;i++){
            for(int j=i+1;j<isConnected.length;j++){
                if(isConnected[i][j]==1){
                    uf.union(i,j);
                }
            }
        }
        return uf.count;
    }
}

class UnionFind {
    int[] parents;
    int count;
    public UnionFind(int n){
        parents=new int[n];
        for(int i=0;i<n;i++){
            parents[i]=i;
        }
        count=n;
    }

    public void union(int a,int b){
        int temp=find(b);
        if(parents[find(a)]!=temp){
            count--;
            parents[find(a)]=temp;
        }
    }

    public int find(int a){
        if(parents[a]!=a){
            parents[a]=find(parents[a]);
        }
        return parents[a];
    }
}