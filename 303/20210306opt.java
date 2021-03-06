class NumArray {
    int[] res;
    public NumArray(int[] nums) {
        res= new int[nums.length];
        if(nums.length==0){
            return;
        }
        res[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            res[i]=nums[i]+res[i-1];
        }
    }
    
    public int sumRange(int i, int j) {
        if(i==0){
            return res[j];
        }
        return res[j]-res[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */