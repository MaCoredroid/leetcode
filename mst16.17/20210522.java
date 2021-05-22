class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0;
        int ans=Integer.MIN_VALUE;
        for(int num:nums){
            if(sum<0){
                sum=num;
            }else{
                sum+=num;
            }
            ans=Math.max(sum,ans);
        }
        return ans;
    }
}