class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int ans=0;
        for(int i=0;i<k;i++){
            ans+=cardPoints[i];
        }
        int left=ans,right=0;
        for(int i=0;i<k;i++){
            right+=cardPoints[cardPoints.length-1-i];
            left-=cardPoints[k-1-i];
            ans=Math.max(ans,left+right);
        }
        return ans;
    }
}