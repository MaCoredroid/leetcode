class Solution {
    public int findRotateSteps(String ring, String key) {
        int n=ring.length();
        int m=key.length();
        List<Integer>[] pos=new List[26];
        for (int i = 0; i < 26; ++i) {
            pos[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<n;i++){
            pos[ring.charAt(i)-'a'].add(i);
        }
        int[][] dp=new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        for(int i:pos[key.charAt(0)-'a']){
            dp[0][i]=Math.min(i,n-i)+1;
        }
        for(int i=1;i<m;i++){
            for(int j:pos[key.charAt(i)-'a']){
                for(int k:pos[key.charAt(i-1)-'a']){
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][k]+1+Math.min(Math.abs(j-k),n-Math.abs(j-k)));
                }
            }
        }
        return Arrays.stream(dp[m-1]).min().getAsInt();
    }
}