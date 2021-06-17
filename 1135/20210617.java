class Solution {
    public int minimumCost(int n, int[][] connections) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->(o1[2]-o2[2]));
        for(int[] c:connections){
            pq.offer(new int[]{c[0]-1,c[1]-1,c[2]});
        }
        UnionFind uf=new UnionFind(n);
        int ans=0;
        while(uf.cnt>1&&!pq.isEmpty()){
            int[] temp=pq.poll();
            if(uf.union(temp[0],temp[1])){
                ans+=temp[2];
            }
        }
        return uf.cnt==1?ans:-1;
    }
}

class UnionFind{
    int[] parents;
    int[] weights;
    int cnt;
    public UnionFind(int n){
        parents=new int[n];
        for(int i=0;i<n;i++){
            parents[i]=i;
        }
        weights=new int[n];
        cnt=n;
    }

    public boolean union(int a,int b){
        int rootA=find(a);
        int rootB=find(b);
        if(rootA==rootB){
            return false;
        }
        if(weights[rootA]==weights[rootB]){
            parents[rootB]=rootA;
            weights[rootA]++;
        }else if(weights[rootA]>weights[rootB]){
            parents[rootB]=rootA;
        }else{
            parents[rootA]=rootB;
        }
        cnt--;
        return true;
    }

    public int find(int a){
        if(parents[a]!=a){
            parents[a]=find(parents[a]);
        }
        return parents[a];
    }
}