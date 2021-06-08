class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges=new ArrayList<>();
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                edges.add(new int[]{i,j,Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1])});
            }
        }
        Collections.sort(edges,(v1,v2)->(v1[2]-v2[2]));
        int ret=0;
        UnionFind uf=new UnionFind(points.length);
        int p=0;
        while(uf.count!=1&&p<edges.size()){
            int[] temp=edges.get(p);
            if(uf.union(temp[0],temp[1])){
                ret+=temp[2];
            }
            p++;
        }
        return ret;
    }
}

class UnionFind{
    int[] parents;
    int count;
    int[] weights;
    public UnionFind(int n){
        this.parents=new int[n];
        for(int i=0;i<parents.length;i++){
            parents[i]=i;
        }
        this.weights=new int[n];
        this.count=n;
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
        if(weights[rootB]>weights[rootA]){
            parents[rootA]=rootB;
        }else if(weights[rootA]>weights[rootB]){
            parents[rootB]=rootA;
        }else{
            parents[rootA]=rootB;
            weights[rootB]++;
        }
        count--;
        return true;
    }
}