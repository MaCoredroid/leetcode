class Solution {
    public int reversePairs(int[] nums) {
        int[] copy=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            copy[i]=nums[i];
        }
        if(nums.length<2){
            return 0;
        }
        return helper(copy,0,nums.length-1,new int[nums.length]);
    }

    private int helper(int[] nums,int left,int right,int[] temp){
        if(left==right){
            return 0;
        }
        int mid=left+(right-left)/2;
        int leftCount=helper(nums,left,mid,temp);
        int rightCount=helper(nums,mid+1,right,temp);
        if(nums[mid+1]>=nums[mid]){
            return leftCount+rightCount;
        }
        return leftCount+rightCount+merge(nums,left,right,mid,temp);
    }

    private int merge(int[] nums,int left,int right,int mid,int[] temp){
        for(int k=left;k<=right;k++){
            temp[k]=nums[k];
        }
        int i=left;
        int j=mid+1;
        int count=0;
        for(int k=left;k<=right;k++){
            if(i==mid+1){
                nums[k]=temp[j];
                j++;
            }else if(j==right+1){
                nums[k]=temp[i];
                i++;
            }else if(temp[j]>=temp[i]){
                nums[k]=temp[i];
                i++;
            }else{
                nums[k]=temp[j];
                count+=(mid-i+1);
                j++;
            }
        }
        return count;
    }
}