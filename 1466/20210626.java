class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            res.add(new ArrayList<>());
        }
        for(int i=0;i<connections.length;i++){
            res.get(connections[i][0]).add(i);
            res.get(connections[i][1]).add(i);
        }
        boolean[] visited=new boolean[n];
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(0);
        int ans=0;
        while(!queue.isEmpty()){
            int p=queue.poll();
            for(Integer index:res.get(p)){
                if(visited[index]){
                    continue;
                }
                visited[index]=true;
                int start=connections[index][0];
                int end=connections[index][1];
                if(p==end){
                    queue.offer(start);
                }else{
                    ans++;
                    queue.offer(end);
                }
            }
        }
        return ans;
    }
}