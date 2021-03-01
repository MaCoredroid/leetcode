class NumArray {
    int[] res;
    int n;
    public NumArray(int[] nums) {
        this.n=nums.length;
        this.res=new int[2*n];
        for(int i=0;i<n;i++){
            res[i+n]=nums[i];
        }
        for(int i=n-1;i>=0;i--){
            res[i]=res[2*i]+res[2*i+1];
        }
    }
    
    public void update(int index, int val) {
        int diff=val-res[index+n];
        res[index+n]=val;
        int i=index+n;
        i/=2;
        while(i>0){
            res[i]+=diff;
            i/=2;
        }
    }
    
    public int sumRange(int left, int right) {
        int sum=0;
        left+=n;
        right+=n;
        while(left<=right){
            if(left%2==1){
                sum+=res[left];
                left++;
            }
            if(right%2==0){
                sum+=res[right];
                right--;
            }
            left/=2;
            right/=2;
        }
        return sum;
    }
}
