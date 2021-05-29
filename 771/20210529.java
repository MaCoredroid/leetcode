class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        boolean[] dp=new boolean[128];
        for(int i=0;i<jewels.length();i++){
            dp[jewels.charAt(i)]=true;
        }
        int cnt=0;
        for(int i=0;i<stones.length();i++){
            if(dp[stones.charAt(i)]){
                cnt++;
            }
        }
        return cnt;
    }
}