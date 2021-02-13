class Solution {
    public int removeDuplicates(int[] nums) {
        int index=0;
        for(int i=0;i<nums.length;i++)
        {
            nums[index]=nums[i];
            index++;
            while(i+1<nums.length&&nums[i+1]==nums[i])
            {
                i++;
            }
        }
        return index;
    }
}