class Solution {
    public int removeDuplicates(int[] nums) {
        int left=0,right=0;
        while(right<nums.length){
            if(nums[left]!=nums[right]){
                nums[++left]=nums[right];
            }
            right++;
        }
        return ++left;
    }
}