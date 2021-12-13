class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]>=target){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        int leftBound=l;
        l=0;
        r=nums.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]<=target){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        if(leftBound>l-1){
            return new int[]{-1,-1};
        }
        return new int[]{leftBound,l-1};
    }
}