class Solution {
    public int pivotIndex(int[] nums) {
        int sumleft=0;
        int sumright=0;
        for(int i=1;i<nums.length;i++){
            sumright+=nums[i];
        }
        for(int i=0;i<nums.length;i++){
            if(sumleft==sumright){
                return i;
            }
            sumleft+=nums[i];
            if(i+1<nums.length){
                sumright-=nums[i+1];
            }
        }
        return -1;
    }
}