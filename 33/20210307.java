class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int middle=(left+right)/2;
            if(target==nums[middle]){
                return middle;
            }
            if(nums[middle]>=nums[0]){
                if(nums[0]<=target&&target<nums[middle]){
                    right=middle-1;
                }else{
                    left=middle+1;
                }
            }else{
                if(nums[middle]<target&&target<=nums[nums.length-1]){
                    left=middle+1;
                }else{
                    right=middle-1;
                }
            }
           
        }
        return -1;
    }
}