class Solution {
    Random ran;
    int[] pre;
    public Solution(int[] w) {
        ran=new Random();
        int n=w.length;
        pre=new int[n+1];
        for(int i=0;i<n;i++){
            pre[i+1]=pre[i]+w[i];
        }
    }
    
    public int pickIndex() {
        int ans=ran.nextInt(pre[pre.length-1]);
        int left=0;
        int right=pre.length-1;
        while(left<=right){
            int mid=left+((right-left)>>1);
            if(pre[mid]==ans){
                return mid;
            }
            if(pre[mid]<ans){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left-1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */