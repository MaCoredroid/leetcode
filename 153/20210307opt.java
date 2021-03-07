class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        if(nums[0]<nums[nums.length-1]){
            return nums[0];
        }
        while(left<right){
            int middle=(left+right)/2;
            if(nums[middle]<nums[0]){
                right=middle;
            }else{
                left=middle+1;
            }
        }
        return nums[left];       
    }
}