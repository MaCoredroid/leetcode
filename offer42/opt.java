class Solution {
    public int maxSubArray(int[] nums) {
        int ans=0;
        int ret=nums[0];
        for(int i=0;i<nums.length;i++)
        {
            if(ans<=0)
            {
                ans=nums[i];
            }
            else
            {
                ans+=nums[i];
            }
            ret=ans>ret?ans:ret;
        }
        return ret;
    }
}