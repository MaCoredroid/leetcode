class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0)
        {
            return 0;
        }
        int value=0;
        int max=nums[0];
        for(int i=0;i<nums.length;i++)
        {
            if(value<0)
            {
                value=0;
            }
            value+=nums[i];
            max=Math.max(max,value);
        }
        return max;
    }
    
}