class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)
        {
            return 0;
        }
        if(nums.length==1)
        {
            return nums[0];
        }
        return Math.max(myRob(Arrays.copyOfRange(nums,0,nums.length-1)),myRob(Arrays.copyOfRange(nums,1,nums.length)));
    }
    private int myRob(int[] nums)
    {
        int pre=0;
        int cur=0;
        for(int i=0;i<nums.length;i++)       
        {
            int temp=Math.max(cur,pre+nums[i]);
            pre=cur;
            cur=temp;
        }
        return cur;
    }
}