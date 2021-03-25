class Solution {
    public int[] sortArray(int[] nums) {
        for(int i=1;i<nums.length;i*=2){
            for(int j=0;j<nums.length-i;j+=i*2){
                if(j+(i<<1)>=nums.length){
                    mergeSort(nums,j,nums.length-1,j+i-1);
                }else if(j+i-1<nums.length-1){
                    mergeSort(nums,j,j+(i<<1)-1,j+i-1);
                }
            }
        }     
        return nums;   
    }

    private void mergeSort(int[] nums,int left,int right,int mid){
        int[] temp=new int[right-left+5];
        int i=left;int j=mid+1;
        int count=0;
        while(i<=mid||j<=right){
            if(i>=mid+1){
                temp[count++]=nums[j++];
            }else if(j>=right+1){
                temp[count++]=nums[i++];
            }else if(nums[i]<=nums[j]){
                temp[count++]=nums[i++];
            }else{
                temp[count++]=nums[j++];
            }
        }
        for(int p=left;p<=right;p++){
            nums[p]=temp[p-left];
        }
    }


    

    
}