class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        List<int[]> edges = new ArrayList<int[]>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int id=i*n+j;
                if(i>0){
                    edges.add(new int[]{id-n,id,Math.abs(heights[i][j]-heights[i-1][j])});
                }
                if(j>0){
                    edges.add(new int[]{id-1,id,Math.abs(heights[i][j]-heights[i][j-1])});
                }
            }
        }
        Collections.sort(edges, new Comparator<>(){
            public int compare(int[] edge1,int[] edge2){
                return edge1[2]-edge2[2];
            }
        });
        int ans=0;
        UnionFind uf=new UnionFind(m*n);
        for(int[] edge:edges){
            uf.union(edge[0],edge[1]);
            if(uf.isConnected(0,m*n-1)){
                ans=edge[2];
                break;
            }
        }
        return ans;
        
    }
}

class UnionFind{
    int[] parent;
    int count;

    public UnionFind(int n){
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        count=n;
    }

    public void union(int i,int j){
        int rooti=find(i);
        int rootj=find(j);
        if(rooti==rootj){
            return;
        }
        parent[rooti]=rootj;
        count--;
    }

    public int find(int i){
        if(i!=parent[i]){
            parent[i]=find(parent[i]);
        }
        return parent[i];
    }

    public boolean isConnected(int i,int j){
        int rooti=find(i);
        int rootj=find(j);
        return rooti==rootj;
    }
    
}