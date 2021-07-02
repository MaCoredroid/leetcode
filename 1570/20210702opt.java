class SparseVector {
    List<int[]> res;
    SparseVector(int[] nums) {
        res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                res.add(new int[]{i,nums[i]});
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        List<int[]> res1=vec.res;
        int p=0,q=0,ans=0;
        while(p<res.size()&&q<res1.size()){
            if(res.get(p)[0]==res1.get(q)[0]){
                ans+=res.get(p)[1]*res1.get(q)[1];
                p++;
                q++;
            }else if(res.get(p)[0]>res1.get(q)[0]){
                q++;
            }else{
                p++;
            }
        }
        return ans;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);