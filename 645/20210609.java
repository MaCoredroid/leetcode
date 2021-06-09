class Solution {
    public int[] findErrorNums(int[] nums) {
        int dup=-1;
        int miss=-1;
        for(int i=0;i<nums.length;i++){
            int temp=nums[i]<0?-nums[i]:nums[i];
            if(nums[temp-1]<0){
                dup=temp;
            }else{
                nums[temp-1]*=-1;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                miss=i+1;
            }
        }
        return new int[]{dup,miss};
    }
}