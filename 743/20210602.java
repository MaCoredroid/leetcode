class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> map=new HashMap<>();
        for(int[] edge:times){
            if(!map.containsKey(edge[0])){
                List<int[]> ans=new ArrayList<>();
                ans.add(new int[]{edge[1],edge[2]});
                map.put(edge[0],ans);
            }else{
                map.get(edge[0]).add(new int[]{edge[1],edge[2]});
            }
        }
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k-1]=0;
        boolean[] seen=new boolean[n];
        while(true){
            int candidate=-1;
            int candist=Integer.MAX_VALUE;
            for(int i=1;i<=n;i++){
                if(!seen[i-1]&&dist[i-1]<candist){
                    candist=dist[i-1];
                    candidate=i;
                }
            }
            if(candidate==-1){
                break;
            }
            seen[candidate-1]=true;
            if(map.containsKey(candidate)){
                for(int[] target:map.get(candidate)){
                    dist[target[0]-1]=Math.min(dist[target[0]-1],candist+target[1]);
                }
            }
        }
        int ans=0;
        for(int dis:dist){
            if(dis==Integer.MAX_VALUE){
                return -1;
            }
            ans=Math.max(ans,dis);
        }
        return ans;
    }
}