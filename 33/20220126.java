class Solution {
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1,p=0;
        while(left<=right){
            p=left+((right-left)>>1);
            if(target==nums[p]) return p;
            if(nums[p]<nums[left]){
                if(target>=nums[left]){
                    right=p-1;
                }else{
                    if(target>nums[p]){
                        left=p+1;
                    }else{
                        right=p-1;
                    }
                }
            }else{
                if(target>nums[p]){
                    left=p+1;
                }else{
                    if(target>=nums[left]){
                        right=p-1;
                    }else{
                        left=p+1;
                    }
                }
            }
        }
        return -1;
    }
}