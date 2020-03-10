class Solution {
    public int majorityElement(int[] nums) {
        int start=0;
        int end=nums.length-1;
        int index=partition(nums,start,end);
        while(index!=nums.length/2&&start<end)
        {
            if(index>nums.length/2)
            {
                end=index-1;
            }
            else
            {
                start=index+1;
            }
            index=partition(nums,start,end);
        }
        return nums[nums.length/2];
    }
    public int partition(int[] nums,int start,int end)
    {
        int value=nums[start];
        while(start<end)
        {
            while(start<end&&nums[end]>=value)
            {
                end--;
            }
            nums[start]=nums[end];
            while(start<end&&nums[start]<=value)
            {
                start++;
            }
            nums[end]=nums[start];
        }
        nums[start]=value;
        return start;
    }
}