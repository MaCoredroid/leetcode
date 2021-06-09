class Solution {
    public int largestAltitude(int[] gain) {
        int ans=0;
        int res=0;
        for(int temp:gain){
            res+=temp;
            ans=Math.max(res,ans);
        }
        return ans;
    }
}