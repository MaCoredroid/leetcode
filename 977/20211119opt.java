class Solution {
    public int[] sortedSquares(int[] nums) {
        int index=findZero(nums);
        int[] ret=new int[nums.length];
        int l=index-1,r=index;
        for(int i=0;i<nums.length;i++){
            int left=l>=0?nums[l]*nums[l]:Integer.MAX_VALUE;
            int right=r<nums.length?nums[r]*nums[r]:Integer.MAX_VALUE;
            if(left<right){
                ret[i]=left;
                l--;
            }else{
                ret[i]=right;
                r++;
            }
        }
        return ret;
        
    }
    
    public int findZero(int[] nums){
        int l=0,r=nums.length-1;
        while(l<=r){
            int mid=l+((r-l)>>1);
            if(nums[mid]==0){
                return mid;
            }else if(nums[mid]>0){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
}