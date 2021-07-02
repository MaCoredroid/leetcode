class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] ret=new int[n];
        int left=1,right=1;
        ret[0]=1;
        for(int i=1;i<ret.length;i++){
            left*=nums[i-1];
            ret[i]=left;
        }
        for(int i=ret.length-2;i>=0;i--){
            right*=nums[i+1];
            ret[i]*=right;
        }
        return ret;
    }
}