class Solution {
    public void nextPermutation(int[] nums) {
        int prev=Integer.MIN_VALUE;
        int i=nums.length-1;
        while(i>=0){
            if(nums[i]<prev){
                break;
            }else{
                prev=nums[i];
            }
            i--;
        }
        if(i<0){
            Arrays.sort(nums);
            return;
        }
        int j=nums.length-1;
        while(nums[j]<=nums[i]){
            j--;
        }
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        if(i+1==nums.length-1){
            return;
        }
        sort(nums,i+1,nums.length-1);
    }

    private void sort(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        int i=left;
        int j=right;
        int pivot=nums[i];
        while(i<j){
            while(i<j&&nums[j]>=pivot){
                j--;
            }
            nums[i]=nums[j];
            while(i<j&&nums[i]<=pivot){
                i++;
            }
            nums[j]=nums[i];
        }
        nums[i]=pivot;
        sort(nums,left,i-1);
        sort(nums,i+1,right);
    }
}