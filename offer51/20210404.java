class Solution {
    
    public int reversePairs(int[] nums) {
        if(nums.length==0||nums.length==1){
            return 0;
        }
        return helper(nums,0,nums.length-1,new int[nums.length]);
    }

    private int helper(int[] nums,int left,int right,int[] temp){
        if(left==right){
            return 0;
        }
        int mid=(left+right)/2;
        int leftAns=helper(nums,left,mid,temp);
        int rightAns=helper(nums,mid+1,right,temp);
        if(nums[mid]<=nums[mid+1]){
            return leftAns+rightAns;
        }
        int count=0;
        int pointer1=left;
        int pointer2=mid+1;
        for(int i=left;i<=right;i++){
            if(pointer1==mid+1){
                temp[i]=nums[pointer2++];
            }else if(pointer2==right+1){
                temp[i]=nums[pointer1++];
            }else if(nums[pointer1]<=nums[pointer2]){
                temp[i]=nums[pointer1++];
            }else{
                temp[i]=nums[pointer2++];
                count+=mid-pointer1+1;
            }
        }
        for(int i=left;i<=right;i++){
            nums[i]=temp[i];
        }
        return count+leftAns+rightAns;

    }

   

    
}