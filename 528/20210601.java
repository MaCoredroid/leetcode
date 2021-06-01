class Solution {
    List<Integer> sum=new ArrayList<>();
    int pre=0;
    Random rand=new Random();
    public Solution(int[] w) {
        for(int x:w){
            pre+=x;
            sum.add(pre);
        }
    }
    
    public int pickIndex() {
        int target=rand.nextInt(pre);
        int left=0;
        int right=sum.size()-1;
        while(left<=right){
            int mid=left+((right-left)>>1);
            if(sum.get(mid)>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */