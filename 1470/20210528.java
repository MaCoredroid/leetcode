class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ret=new int[nums.length];
        int pointer=0;
        int left=0;
        int right=nums.length/2;
        while(pointer<ret.length){
            ret[pointer++]=nums[left++];
            ret[pointer++]=nums[right++];
        }
        return ret;
    }
}