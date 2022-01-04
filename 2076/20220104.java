class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        UnionFind uf=new UnionFind(n);
        boolean[] ans=new boolean[requests.length];
        int p=0;
        for(int[] request:requests){
            int pA=uf.find(request[0]);
            int pB=uf.find(request[1]);
            boolean flag=true;
            for(int[] res:restrictions){
                int p1=uf.find(res[0]);
                int p2=uf.find(res[1]);
                if((p1==pA&&p2==pB)||(p1==pB&&p2==pA)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                uf.union(request[0],request[1]);
            }
            ans[p++]=flag;
        }
        return ans;
    }
}

class UnionFind{
    int[] parents;
    public UnionFind(int n){
        this.parents=new int[n];
        for(int i=0;i<n;i++){
            parents[i]=i;
        }
    }
    
    public int find(int i){
        if(parents[i]!=i){
            parents[i]=find(parents[i]);
        }
        return parents[i];
    }
    
    public void union(int a,int b){
        int pA=find(a);
        int pB=find(b);
        if(pA!=pB){
            parents[pA]=pB;
        }
    }
}

