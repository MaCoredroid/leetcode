class Solution {
    public int majorityElement(int[] nums) {
        int times=1;
        int num=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==num)
            {
                times++;
            }
            else
            {
                times--;
                if(times==0)
                {
                    num=nums[i];
                    times=1;
                }
            }
        }
        return num;
    }
}