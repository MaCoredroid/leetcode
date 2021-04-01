class Solution {
    public void moveZeroes(int[] nums) {
        int pointer=0;
        int count=0;
        while(pointer<nums.length){
            if(nums[pointer]==0){
                count++;
            }else{
                nums[pointer-count]=nums[pointer];
            }
            pointer++;
        }
        while(count>0){
            nums[nums.length-count]=0;
            count--;
        }
    }
}