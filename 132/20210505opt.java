class Solution {
    public int minCut(String s) {
        int[] dp=new int[s.length()];
        Arrays.fill(dp,s.length()-1);
        for(int i=0;i<s.length();i++){
            helper(s,i,i,dp);
            helper(s,i,i+1,dp);
        }
        return dp[dp.length-1];

    }

    private void helper(String s, int i,int j,int[] dp){
        int len=s.length();
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            dp[j]=Math.min(dp[j],(i==0?0:dp[i-1]+1));
            i--;
            j++;
        }
    }
}