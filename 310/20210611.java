class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res=new ArrayList<>();
        if(n==1){
            res.add(0);
            return res;
        }
        int[] degree=new int[n];
        List<List<Integer>> map=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for(int [] edge:edges){
            degree[edge[0]]++;
            degree[edge[1]]++;
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==1){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            res=new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                int temp=queue.poll();
                res.add(temp);
                List<Integer> neighbours=map.get(temp);
                for(Integer next:neighbours){
                    degree[next]--;
                    if(degree[next]==1){
                        queue.offer(next);
                    }
                }
            }
        }
        return res;
    }
}