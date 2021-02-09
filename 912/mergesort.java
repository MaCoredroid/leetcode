class Solution {
    int[] res;
    public int[] sortArray(int[] nums) {
        res=new int[nums.length];
        merge(nums,0,nums.length-1);
        return nums;
    }

    public void merge(int[] nums, int left, int right)
    {
        if(left>=right)
        {
            return;
        }
        int mid=(left+right)/2;
        merge(nums,left,mid);
        merge(nums,mid+1,right);
        int i=left;
        int j=mid+1;
        int index=0;
        while(i<=mid&&j<=right)
        {
            if(nums[i]<nums[j])
            {
                res[index]=nums[i];
                i++;
            }
            else
            {
                res[index]=nums[j];
                j++;
            }
            index++;
        }
        while(i<=mid)
        {
            res[index]=nums[i];
            i++;
            index++;
        }
        while(j<=right)
        {
            res[index]=nums[j];
            j++;
            index++;
        }
        index=0;
        for(int p=left;p<=right;p++)
        {
            nums[p]=res[index];
            index++;
        }

    }

    
}