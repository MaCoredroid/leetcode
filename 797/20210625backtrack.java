class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> curr=new ArrayList<>();
        curr.add(0);
        backTrack(graph,0,curr);
        return res;
    }

    private void backTrack(int[][] graph, int index,List<Integer> curr){
        if(index==graph.length-1){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int next:graph[index]){
            curr.add(next);
            backTrack(graph,next,curr);
            curr.remove(curr.size()-1);
        }
    }
}