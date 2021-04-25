class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        int length=Integer.MIN_VALUE;
        for(String word:wordDict){
            length=Math.max(length,word.length());
        }
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=Math.max(0,i-length);j<i;j++){
                if(dp[j]&&set.contains(s.substring(j,i))){
                    dp[i]=true;
                }
            }
        }
        return dp[dp.length-1];
    }
}