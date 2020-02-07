class Solution {
    public List<Integer> sortArray(int[] nums) {
        ArrayList output=new ArrayList<Integer>();
        if(nums.length==0)
        {
            return output;
        }
        quickSort(nums,0,nums.length-1);
        for(int i=0;i<nums.length;i++)
        {
            output.add(nums[i]);
        }
        return output;
    }
    public void quickSort(int[] nums, int start, int end)
    {
        if(start>=end)
        {
            return;
        }
        int left=start;
        int right=end;
        int privo=nums[(left+right)/2];
        while(left<=right)
        {
            while(left<=right&&nums[left]<privo)
            {
                left++;
            }
            while(left<=right&&nums[right]>privo)
            {
                right--;
            }
            if(left<=right)
            {
                int temp=nums[right];
                nums[right]=nums[left];
                nums[left]=temp;
                left++;
                right--;
            }
        }
        quickSort(nums,start,right);
        quickSort(nums,left,end);
    }
}