class NumArray {
    int[] res;
    int[] parents;
    public NumArray(int[] nums) {
        this.res=nums;
        parents=new int[nums.length+1];
        for(int i=0;i<nums.length;i++)
        {
            updateBit(i,nums[i]);
        }
    }
    public void updateBit(int index, int diff)
    {
        index++;
        while(index<=res.length){
            parents[index]+=diff;
            index+=index&(-index);
        }
    }
    public void update(int index, int val) {
        int diff=val-res[index];
        res[index]=val;
        updateBit(index,diff);
    }
    public int sum(int index){
        index++;
        int sum=0;
        while(index>0){
            sum+=parents[index];
            index-=index&(-index);
        }
        return sum;
    }
    public int sumRange(int left, int right) {

        return sum(right)-sum(left-1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */