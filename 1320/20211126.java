class Solution {
    public int minimumDistance(String word) {
        char[] ch=word.toCharArray();
        int n=word.length();
        if(n<3) return 0;
        int[] dp=new int[27];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[26]=dist(ch[0],ch[1]);
        dp[ch[0]-'A']=0;
        for(int k=2;k<ch.length;k++){
            int add=dist(ch[k-1],ch[k]);
            int min=dp[26];
            for(int i=0;i<27;i++){
                if(dp[i]<min) min=Math.min(min,dp[i]+dist(ch[k],(char)(i+'A')));
                if(dp[i]!=Integer.MAX_VALUE) dp[i]+=add;
            }
            dp[ch[k-1]-'A']=Math.min(dp[ch[k-1]-'A'],min);
        }
        int ans = Integer.MAX_VALUE;
        for(int x: dp) ans = Math.min(ans, x);
        
        return ans;
    }
    
    public int dist(char a,char b){
        int i=a-'A',j=b-'A';
        return Math.abs(i/6-j/6)+Math.abs(i%6-j%6);
    }
}