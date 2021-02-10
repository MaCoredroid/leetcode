class Solution {
    public int[] sortArray(int[] nums) {
        int len=nums.length-1;
        buildMaxHeap(nums,nums.length-1);
        for(int i=len;i>=0;i--)
        {
            swap(nums,i,0);
            maxHeap(nums,0,i-1);
        }
        return nums;
    }


    private void buildMaxHeap(int[] nums,int len)
    {
        for(int j=len/2;j>=0;j--)
        {
            maxHeap(nums,j,len);
        }
    }

    private void maxHeap(int[] nums,int i,int len )
    {
        while(2*i+1<=len)
        {
            int leftChild=2*i+1;
            int rightChild=2*i+2;
            int large=0;
            if(leftChild<=len&&nums[leftChild]>nums[i])
            {
                large=leftChild;
            }
            else
            {
                large=i;
            }
            if(rightChild<=len&&nums[rightChild]>nums[large])
            {
                large=rightChild;
            }
            if(large!=i)
            {
                swap(nums,large,i);
                i=large;
            }
            else
            {
                break;
            }
        }
    }


    private void swap(int[] nums,int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    
}