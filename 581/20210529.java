class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Integer min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        boolean flag=false;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                flag=true;
                if(flag){
                    min=Math.min(min,nums[i]);
                }
            }
        }
        flag=false;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>nums[i+1]){
                flag=true;
                if(flag){
                    max=Math.max(max,nums[i]);
                }
            }
        }
        int left=0,right=0;
        for(left=0;left<nums.length;left++){
            if(nums[left]>min){
                break;
            }
        }
        for(right=nums.length-1;right>=0;right--){
            if(nums[right]<max){
                break;
            }
        }
        return right>left?right-left+1:0;
    }
}