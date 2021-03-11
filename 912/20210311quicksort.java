class Solution {
    public int[] sortArray(int[] nums) {
        partition(nums,0,nums.length-1);
        return nums;
    }

    private void partition(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        int p=left;int q=right;
        int temp=nums[p];
        while(p<q){
            while(p<q&&nums[q]>=temp){
                q--;
            }
            nums[p]=nums[q];
            while(p<q&&nums[p]<=temp){
                p++;
            }
            nums[q]=nums[p];
        }
        nums[p]=temp;
        partition(nums,left,p-1);
        partition(nums,p+1,right);

    }
}