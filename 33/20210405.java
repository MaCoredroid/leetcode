class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>nums[nums.length-1]){
                if(target>=nums[0]&&target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                if(target>nums[mid]&&target<=nums[nums.length-1]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;
        

    }
}