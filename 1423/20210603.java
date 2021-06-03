class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int[] pre=new int[n+1];
        for(int i=0;i<n;i++){
            pre[i+1]=cardPoints[i]+pre[i];
        }
        if(k==n){
            return pre[n];
        }
        int temp=0;
        for(int i=0;i<=k;i++){
            int front=i;
            int end=k-i;
            int ans=0;
            ans+=pre[front]-pre[0];
            ans+=pre[n]-pre[n-(k-i)];
            temp=Math.max(ans,temp);
        }
        return temp;
    }
}