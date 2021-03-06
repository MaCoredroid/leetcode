class NumArray {
    int[] res;
    public NumArray(int[] nums) {
        res= new int[2*nums.length];
        for(int i=0;i<nums.length;i++){
            res[i+nums.length]=nums[i];
        }
        for(int i=nums.length-1;i>=0;i--){
            res[i]=res[2*i]+res[2*i+1];
        }
    }
    
    public int sumRange(int i, int j) {
        int left=i+res.length/2;
        int right=j+res.length/2;
        int ret=0;
        while(left<=right){
            if(left%2==1){
                ret+=res[left];
                left++;
            }
            if(right%2==0){
                ret+=res[right];
                right--;
            }
            left/=2;
            right/=2;
        }
        return ret;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */