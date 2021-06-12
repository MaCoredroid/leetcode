class Solution {
    ArrayList<Integer>[] graph;
    int[] answer;
    int[] quiet;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int N=quiet.length;
        answer=new int[N];
        this.quiet=quiet;
        graph=new ArrayList[N];
        for(int i=0;i<N;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] edge:richer){
            graph[edge[1]].add(edge[0]);
        }
        Arrays.fill(answer,-1);
        for(int i=0;i<N;i++){
            dfs(i);
        }
        return answer;
    }

    private int dfs(int node){
        if(answer[node]==-1){
            int temp=node;
            for(Integer next:graph[node]){
                int ret=dfs(next);
                if(quiet[ret]<quiet[temp]){
                    temp=ret;
                }
            }
            answer[node]=temp;
        }
        return answer[node];
    }
}