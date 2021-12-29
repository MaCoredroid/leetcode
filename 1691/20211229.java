class Solution {
    public int maxHeight(int[][] c) {
        for(int[] A:c){
            Arrays.sort(A);
        }
        Arrays.sort(c,(o1,o2)->(o1[0]==o2[0]?(o1[1]==o2[1]?o1[2]-o2[2]:o1[1]-o2[1]):(o1[0]-o2[0])));
        int n=c.length;
        int ans=0;
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=c[i][2];
            for(int j=0;j<i;j++){
                if(c[j][0]<=c[i][0]&&c[j][1]<=c[i][1]&&c[j][2]<=c[i][2]){
                    dp[i]=Math.max(dp[i],dp[j]+c[i][2]);
                }
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}