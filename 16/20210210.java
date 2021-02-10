class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff=Integer.MAX_VALUE;
        int ans=0;
        for(int i=0;i<nums.length-2;i++)
        {
            int start=i+1;
            int end=nums.length-1;
            if (nums[i] + nums[i + 1] + nums[i + 2] > target) {
                start = i + 1;
                end = i + 2;
            } else if (nums[i] + nums[nums.length - 2] + nums[nums.length - 1] < target){
                start =  nums.length - 2;
                end = nums.length - 1;
            }
            while(start<end)
            {
                if(Math.abs(nums[i]+nums[start]+nums[end]-target)<diff)
                {
                    ans=nums[i]+nums[start]+nums[end];
                    diff=Math.abs(nums[i]+nums[start]+nums[end]-target);
                    if(diff==0)
                    {
                        return ans;
                    }
                }
                if(nums[i]+nums[start]+nums[end]>target)
                {
                    end--;
                }
                else
                {
                    start++;
                }
            }
            
            while(i+1<nums.length&&nums[i+1]==nums[i])
            {
                i++;
            }
            
        }
        return ans;
    }
}