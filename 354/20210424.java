class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                if(a[0]==b[0]){
                    return b[1]-a[1];
                }else{
                    return a[0]-b[0];
                }
            }
        });
        int[] dp=new int[envelopes.length+1];
        int len=1;
        dp[len]=envelopes[0][1];
        for(int i=1;i<envelopes.length;i++){
            if(dp[len]<envelopes[i][1]){
                dp[++len]=envelopes[i][1];
            }else{
                int left=1;
                int right=len-1;
                while(left<=right){
                    int middle=(left+right)/2;
                    if(dp[middle]<envelopes[i][1]){
                        left=middle+1;
                    }else{
                        right=middle-1;
                    }
                }
                dp[left]=envelopes[i][1];
            }
        }
        return len;
    }

    
}