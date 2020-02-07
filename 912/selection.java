class Solution {
    public List<Integer> sortArray(int[] nums) {
        ArrayList output=new ArrayList<Integer>();
        if(nums.length==0)
        {
            return output;
        }
        for(int i=0;i<nums.length;i++)
        {
            int minIndex=i;
            for(int j=i;j<nums.length;j++)
            {
                if(nums[j]<nums[minIndex])
                {
                    minIndex=j;
                }
            }
            int temp=nums[i];
            nums[i]=nums[minIndex];
            nums[minIndex]=temp;
        }
        for(int i=0;i<nums.length;i++)
        {
            output.add(nums[i]);
        }
        return output;
    }
}