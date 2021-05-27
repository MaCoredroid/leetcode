class Solution {
    public int[] sortedSquares(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+((right-left)>>1);
            if(nums[mid]>0){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        int p1=left-1;
        int p2=left;
        int p=0;
        int[] ans=new int[nums.length];
        while(p1>=0||p2<nums.length){
            int num1=p1>=0?nums[p1]*nums[p1]:Integer.MAX_VALUE;
            int num2=p2<nums.length?nums[p2]*nums[p2]:Integer.MAX_VALUE;
            if(num1<num2){
                ans[p++]=num1;
                p1--;
            }else{
                ans[p++]=num2;
                p2++;
            }
        }
        return ans;
    }
}