class Solution {
    public int[] sortArray(int[] nums) {
        for(int i=1;i<nums.length;i++)
        {
            int value=nums[i];
            int point=i-1;
            while(point>=0&&nums[point]>value)
            {
                int temp=nums[point];
                nums[point]=nums[point+1];
                nums[point+1]=temp;
                point--;
            }
            
        }
        return nums;
    }

    
}