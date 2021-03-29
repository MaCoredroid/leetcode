class Solution {
    public void nextPermutation(int[] nums) {
        int prev=Integer.MIN_VALUE;
        int i=nums.length-1;
        while(i>=0){
            if(nums[i]<prev){
                break;
            }else{
                prev=nums[i];
            }
            i--;
        }
        if(i<0){
            Arrays.sort(nums);
            return;
        }
        int j=nums.length-1;
        while(nums[j]<=nums[i]){
            j--;
        }
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        if(i+1==nums.length-1){
            return;
        }
        reverse(nums,i+1,nums.length-1);
    }

    private void reverse(int[] nums,int left,int right){
        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
}