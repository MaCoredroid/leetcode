class Solution {
    public int chaseGame(int[][] edges, int startA, int startB) {
        int n=edges.length;
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        int[] nums=new int[n+1];
        for(int[] edge:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
            nums[edge[0]]++;
            nums[edge[1]]++;
        }
        int ring=n;
        Queue<Integer> queue=new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(nums[i]==1){
                queue.offer(i);
            }
        }
        int[] distA=new int[n+1];
        int[] distB=new int[n+1];
        bfs(list,distA,startA);
        bfs(list,distB,startB);
        while(!queue.isEmpty()){
            Integer temp=queue.poll();
            ring--;
            for(Integer neighbour:list.get(temp)){
                nums[neighbour]--;
                if(nums[neighbour]==1){
                    queue.offer(neighbour);
                }
            }
        }
        int ans=1;
        for(int i=1;i<=n;i++){
            if(distA[i]>distB[i]+1){
                if(nums[i]>1&&ring>3){
                    ans=-1;
                    break;
                }else{
                    ans=Math.max(ans,distA[i]);
                }
            }
        }
        return ans;

    }

    private void bfs(List<List<Integer>> list,int[] dist,int target){
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(target);
        dist[target]=0;
        while(!queue.isEmpty()){
            int temp=queue.poll();
            for(Integer neighbour:list.get(temp)){
                if(dist[neighbour]==0&&neighbour!=target){
                    dist[neighbour]=dist[temp]+1;
                    queue.offer(neighbour);
                }
            }
        }
    }
}