class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0)
        {
            return 0;
        }
        int count = nums[0];
        int ret = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(count<0)
            {
                count=0;
            }
            count+=nums[i];
            ret=Math.max(ret,count);
        }
        return ret;
    }
    
}