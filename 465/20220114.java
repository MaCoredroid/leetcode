class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int[] t:transactions){
            map.put(t[0],map.getOrDefault(t[0],0)-t[2]);
            map.put(t[1],map.getOrDefault(t[1],0)+t[2]);
        }
        return dfs(0,new ArrayList<>(map.values()));
    }
    
    public int dfs(int start,List<Integer> debt){
        while(start<debt.size()&&debt.get(start)==0){
            start++;
        }
        if(debt.size()==0) return 0;
        int r=Integer.MAX_VALUE;
        for(int i=start+1;i<debt.size();i++){
            if (debt.get(start) * debt.get(i) < 0) {
                debt.set(i, debt.get(i) + debt.get(start));
                r = Math.min(r, 1 + dfs(start + 1, debt));
                debt.set(i, debt.get(i) - debt.get(start));
            }
        }
        return r==Integer.MAX_VALUE?0:r;
        
    }
}