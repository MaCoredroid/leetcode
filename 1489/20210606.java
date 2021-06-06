class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m=edges.length;
        int[][] newEdges = new int[m][4];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < 3; ++j) {
                newEdges[i][j] = edges[i][j];
            }
            newEdges[i][3] = i;
        }
        Arrays.sort(newEdges, (u,v)->(u[2]-v[2]));
        UnionFind uf=new UnionFind(n);
        int value=0;
        for(int[] edge:newEdges){
            if(uf.union(edge[0],edge[1])){
                value+=edge[2];
            }
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < 2; ++i) {
            ans.add(new ArrayList<Integer>());
        }
        for(int i=0;i<m;i++){
            UnionFind temp=new UnionFind(n);
            int v=0;
            for(int j=0;j<m;j++){
                if(j!=i&&temp.union(newEdges[j][0],newEdges[j][1])){
                    v+=newEdges[j][2];
                }
            }
            if(temp.setCount!=1||(temp.setCount==1&&v>value)){
                ans.get(0).add(newEdges[i][3]);
                continue;
            }
            temp=new UnionFind(n);
            v=newEdges[i][2];
            temp.union(newEdges[i][0],newEdges[i][1]);
            for(int j=0;j<m;j++){
                if(j!=i&&temp.union(newEdges[j][0],newEdges[j][1])){
                    v+=newEdges[j][2];
                }
            }
            if(v==value){
                ans.get(1).add(newEdges[i][3]);
            }
        }
        return ans;
    }
}

class UnionFind{
    int[] parents;
    int[] size;
    int n;
    int setCount;
    public UnionFind(int n){
        this.n=n;
        this.setCount=n;
        this.parents=new int[n];
        this.size=new int[n];
        for(int i=0;i<n;i++){
            parents[i]=i;
        }
    }

    public boolean union(int a,int b){
        int rootA=find(a);
        int rootB=find(b);
        if(rootA!=rootB){
            if(size[rootA]>size[rootB]){
                parents[rootB]=rootA;
            }else if(size[rootA]<size[rootB]){
                parents[rootA]=rootB;
            }else{
                parents[rootB]=rootA;
                size[rootA]++;
            }
            setCount--;
            return true;
        }
        return false;
    }

    public int find(int a){
        if(a!=parents[a]){
            parents[a]=find(parents[a]);
        }
        return parents[a];
    }

}