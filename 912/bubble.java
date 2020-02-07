class Solution {
    public List<Integer> sortArray(int[] nums) {
        ArrayList output=new ArrayList<Integer>();
        if(nums.length==0)
        {
            return output;
        }
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<nums.length-i-1;j++)
            {
                if(nums[j+1]<nums[j])
                {
                    int temp=nums[j+1];
                    nums[j+1]=nums[j];
                    nums[j]=temp;
                }
            }
        }
        for(int i=0;i<nums.length;i++)
        {
            output.add(nums[i]);
        }
        return output;
    }
}