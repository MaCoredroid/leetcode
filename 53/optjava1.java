class Solution {
    public int maxSubArray(int[] nums) {
        int ans=nums[0];
        int current=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            current=current>0?nums[i]+current:nums[i];
            ans=ans>current?ans:current;
        }
        return ans;
    }
    
}