class Solution {
    public int missingNumber(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int middle=(left+right)/2;
            if(nums[middle]>middle){
                right=middle-1;
            }else{
                left=middle+1;
            }
        }
        return left;
    }
}