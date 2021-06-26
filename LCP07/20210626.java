class Solution {
    public int numWays(int n, int[][] relation, int k) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int[] a:relation){
            if(!map.containsKey(a[1])){
                map.put(a[1],new ArrayList<>());
            }
            map.get(a[1]).add(a[0]);
        }
        int[][] dp=new int[k+1][n];
        dp[0][0]=1;
        for(int i=1;i<=k;i++){
            for(int j=0;j<n;j++){
                if(map.containsKey(j)){
                    for(Integer pre:map.get(j)){
                        dp[i][j]+=dp[i-1][pre];
                    }
                }
            }
        }
        return dp[k][n-1];

    }
}