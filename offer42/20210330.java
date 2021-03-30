class Solution {
    public int maxSubArray(int[] nums) {
        int ans=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(sum<0){
                sum=0;
            }
            ans=Math.max(sum+nums[i],ans);
            sum+=nums[i];
        }
        return ans;
    }
}