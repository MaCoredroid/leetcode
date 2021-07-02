class SparseVector {
    HashMap<Integer,Integer> map;
    SparseVector(int[] nums) {
        map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                map.put(i,nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        HashMap<Integer,Integer> map1=vec.map;
        int ret=0;
        if(map.size()>map1.size()){
            HashMap<Integer,Integer> temp=map;
            map=map1;
            map1=temp;
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(map1.containsKey(entry.getKey())){
                ret+=entry.getValue()*(map1.get(entry.getKey()));
            }
        }
        return ret;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);