class Solution {
    
    public int reversePairs(int[] nums) {
        int n = nums.length;
        int[] tmp = new int[n];
        System.arraycopy(nums, 0, tmp, 0, n);
        Arrays.sort(tmp);
        for(int i=0;i<nums.length;i++){
            nums[i]=Arrays.binarySearch(tmp,nums[i])+1;
        }
        BIT bit=new BIT(nums.length);
        int ans=0;
        for(int i=nums.length-1;i>=0;i--){
            ans+=bit.query(nums[i]-1);
            bit.update(nums[i]);
        }
        return ans;


    }

    class BIT{
        int[] res;
        
        public BIT(int n){
            
            res=new int[n+1];
        }

        private int lowestbit(int x){
            return x & (-x);
        }

        public int query(int x){
            int ret=0;
            while(x>0){
                ret+=res[x];
                x-=lowestbit(x);
            }
            return ret;
        }

        public void update(int x){
            while(x<res.length){
                res[x]++;
                x+=lowestbit(x);
            }
        }
    }

   

    
}