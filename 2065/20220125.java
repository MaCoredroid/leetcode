class Solution {
    int ans=0;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n=values.length;
        List<int[]>[] adj=new List[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] e:edges){
            adj[e[0]].add(new int[]{e[1],e[2]});
            adj[e[1]].add(new int[]{e[0],e[2]});
        }
        int[] seen=new int[n];
        seen[0]++;
        dfs(adj,seen,0,maxTime,values,values[0]);
        return ans;
        
    }
    
    public void dfs(List<int[]>[] adj,int[] seen,int src,int maxTime,int[] values,int sum){
        if(src==0){
            ans=Math.max(ans,sum);
        }
        if(maxTime<0) return;
        for(int[] next:adj[src]){
            int dst=next[0],t=next[1];
            if(maxTime-t<0) continue;
            seen[dst]++;
            dfs(adj,seen,dst,maxTime-t,values,sum+(seen[dst]==1?values[dst]:0));
            seen[dst]--;
        }
    }
}