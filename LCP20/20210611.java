class Solution {
    int inc;
    int dec;
    int[] jump;
    int[] cost;
    Map<Long, Long> map = new HashMap<>();

    public int busRapidTransit(int target, int inc, int dec, int[] jump, int[] cost) {
        this.inc = inc;
        this.dec = dec;
        this.jump = jump;
        this.cost = cost;
        return (int) (dfs(target) % 1000000007);
    }

    private long dfs(long target) {
        if(map.containsKey(target)){
            return map.get(target);
        }
        map.put(target,(long)1e15);
        long ans=target*inc;
        for(int i=0;i<jump.length;i++){
            ans=Math.min(ans,dfs(target/jump[i]+1)+cost[i]+(jump[i]-target%jump[i])*dec);
            ans=Math.min(ans,dfs(target/jump[i])+cost[i]+(target%jump[i])*inc);
        }
        map.put(target,ans);
        return ans;
    }
}
