class Solution {
    public int[] sortArray(int[] nums) {
        buildMaxHeap(nums,nums.length-1);
        for(int i=nums.length-1;i>=0;i--){
            swap(nums,0,i);
            maxHeap(nums,0,i-1);
        }
        return nums;
    }

    private void buildMaxHeap(int[] nums,int len){
        for(int i=len/2;i>=0;i--){
            maxHeap(nums,i,len);
        }
    }

    private void maxHeap(int[] nums,int i,int len){
        while(2*i+1<=len){
            int left=2*i+1;
            int right=2*i+2;
            int large=i;
            if(left<=len&&nums[left]>nums[large]){
                large=left;
            }
            if(right<=len&&nums[right]>nums[large]){
                large=right;
            }
            if(large!=i){
                swap(nums,i,large);
                i=large;
            }else{
                break;
            }
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    


    

    
}