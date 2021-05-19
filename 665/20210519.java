class Solution {
    public boolean checkPossibility(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            int x=nums[i],y=nums[i+1];
            if(x>y){
                nums[i]=y;
                if(isSorted(nums)){
                    return true;
                }
                nums[i]=x;
                nums[i+1]=x;
                return isSorted(nums);
            }
        }
        return true;
    }

    private boolean isSorted(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                return false;
            }
        }
        return true;
    }
}