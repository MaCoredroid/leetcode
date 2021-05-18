class Solution {
    public int findPeakElement(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=left+((right-left)>>1);
            if(mid+1==nums.length){
                return mid;
            }
            if(nums[mid+1]>nums[mid]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
}