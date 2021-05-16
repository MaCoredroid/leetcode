class Solution {
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+((right-left)>>1);
            if(nums[mid]==target){
                int count=1;
                int l=mid-1,r=mid+1;
                while(l>=0&&nums[l]==target){
                    count++;
                    l--;
                }
                while(r<nums.length&&nums[r]==target){
                    count++;
                    r++;
                }
                return count;
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return 0;
    }
}