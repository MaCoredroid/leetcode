class Solution {
    public String countAndSay(int n) {
        String[] dp=new String[n+1];
        dp[1]="1";
        for(int i=2;i<=n;i++){
            dp[i]=helper(dp[i-1]);
        }
        return dp[n];
    }
    
    private String helper(String s){
        int count=1;
        int pointer=0;
        StringBuilder sb=new StringBuilder();
        while(pointer<s.length()){
            while(pointer+1<s.length()&&s.charAt(pointer)==s.charAt(pointer+1)){
                pointer++;
                count++;
            }
            sb.append(count).append(s.charAt(pointer));
            count=1;
            pointer++;

        }
        return sb.toString();
    }
}