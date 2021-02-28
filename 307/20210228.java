class NumArray {
    private int[] b;
    private int len;
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums=nums;
        this.len=(int)Math.ceil(Math.sqrt(nums.length)/1);
        this.b=new int[nums.length/len+1];
        for(int i=0;i<nums.length;i++)
        {
            b[i/len]+=nums[i];
        }
    }
    
    public void update(int index, int val) {
        b[index/this.len]-=nums[index];
        b[index/this.len]+=val;
        nums[index]=val;
        

    }
    
    public int sumRange(int left, int right) {
        int res=0;
        if(left/len==right/len){
            for(int i=left;i<=right;i++){
                res+=nums[i];
            }
        }
        else{
            int leftb=left/len;
            int rightb=right/len;
            for(int i=left;i<len*(leftb+1);i++)
            {
                res+=nums[i];
            }
            for(int i=leftb+1;i<=rightb-1;i++)
            {
                res+=b[i];
            }
            for(int i=len*rightb;i<=right;i++)
            {
                res+=nums[i];
            }
        }
        return res;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */