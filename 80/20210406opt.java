class Solution {
    public int removeDuplicates(int[] nums) {
        int pos=2;
        for(int i=2;i<nums.length;i++){
            if(nums[pos-2]!=nums[i]){
                nums[pos++]=nums[i];
            }
        }
        return pos;
    }
}