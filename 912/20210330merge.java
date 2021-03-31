class Solution {
    public int[] sortArray(int[] nums) {
        sort(nums,0,nums.length-1);
        return nums;
    }

    private void sort(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        int mid=(left+right)/2;
        sort(nums,left,mid);
        sort(nums,mid+1,right);
        merge(nums,left,mid,right);
    }

    private void merge(int[] nums,int left,int mid,int right){
        int[] res =new int[right-left+1];
        int i=left;
        int j=mid+1;
        int pointer=0;
        while(i<=mid||j<=right){
            if(i==mid+1){
                res[pointer++]=nums[j++];
            }else if(j==right+1){
                res[pointer++]=nums[i++];
            }else if(nums[i]<nums[j]){
                res[pointer++]=nums[i++];
            }else{
                res[pointer++]=nums[j++];
            }
        }
        for(int p=left;p<=right;p++){
            nums[p]=res[p-left];
        }
    }

    

    

    


    

    
}