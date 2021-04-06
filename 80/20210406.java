class Solution {
    public int removeDuplicates(int[] nums) {
        int pos=1;
        int prev=nums[0];
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==prev){
                if(count>=2){
                    continue;
                }else{
                    count++;
                    nums[pos++]=nums[i];
                }
            }else{
                prev=nums[i];
                count=1;
                nums[pos++]=nums[i];
            }
        }
        return pos;
    }
}