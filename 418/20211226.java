class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int n=sentence.length;
        int[] dp=new int[n];
        for(int i=0,len=0,prev=0;i<n;i++){
            if(i!=0&&len>0) len-=sentence[i-1].length()+1;
            while(len+sentence[prev%n].length()<=cols){
                len+=sentence[(prev++)%n].length()+1;
            }
            dp[i]=prev;
        }
        int cnt=0;
        for(int i=0,k=0;i<rows;i++){
            cnt+=dp[k]-k;
            k=dp[k]%n;
        }
        return cnt/n;
    }
}