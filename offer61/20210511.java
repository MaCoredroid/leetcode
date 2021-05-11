class Solution {
    public boolean isStraight(int[] nums) {
        int zeroCount=0;
        int gapCount=0;
        int temp=-1;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zeroCount++;
            }else{
                if(nums[i]<=temp){
                    return false;
                }
                if(temp!=-1&&nums[i]!=temp+1){
                    gapCount+=nums[i]-temp-1;
                }
                temp=nums[i];
            }
        }
        return zeroCount>=gapCount;
    }
}