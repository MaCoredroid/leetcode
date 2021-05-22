class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(mid%2==1){
                mid--;
            }
            if(mid+1>=nums.length){
                return nums[mid];
            }
            if(nums[mid+1]!=nums[mid]){
                right=mid-1;
            }else{
                left=mid+2;
            }
            
        }
        return nums[left];
    }
}