class Solution {
    public int majorityElement(int[] nums) {
        return majorityElementInSegement(nums,0,nums.length-1);
    }

    public int majorityElementInSegement(int []nums, int left, int right){
        if(left==right){
            return nums[left];
        }else{
            int leftM=majorityElementInSegement(nums,left,(left+right)/2);
            int rightM=majorityElementInSegement(nums,(left+right)/2+1,right);
            int leftCount=0;
            int rightCount=0;
            for(int i=left;i<=right;i++){
                if(nums[i]==leftM){
                    leftCount++;
                }else if(nums[i]==rightM){
                    rightCount++;
                }
            }
            if(leftCount>rightCount){
                return leftM;
            }else{
                return rightM;
            }
        }
    }
}