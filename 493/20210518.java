class Solution {
    public int reversePairs(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    public int helper(int[] nums,int left,int right){
        if(left==right){
            return 0;
        }
        int mid=left+((right-left)>>1);
        int ans1=helper(nums,left,mid);
        int ans2=helper(nums,mid+1,right);
        int ret=ans1+ans2;
        int i=left;
        int j=mid+1;
        while(i<=mid){
            while(j<=right&&(long)nums[j]*2<(long)nums[i]){
                j++;
            }
            ret+=j-mid-1;
            i++;
            
        }
        int pointer=0;
        int l=left,r=mid+1;
        int[] sorted=new int[right-left+1];
        while(l<=mid||r<=right){
            if(l>mid){
                sorted[pointer++]=nums[r++];
            }else if(r>right){
                sorted[pointer++]=nums[l++];
            }else{
                if(nums[l]<nums[r]){
                    sorted[pointer++]=nums[l++];
                }else{
                    sorted[pointer++]=nums[r++];
                }
            }
        }
        for(int p=left;p<=right;p++){
            nums[p]=sorted[p-left];
        }
        return ret;
    }
}