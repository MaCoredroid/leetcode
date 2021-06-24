class Solution {
    public int findKthNumber(int m, int n, int k) {
        int left=1;
        int right=m*n;
        while(left<=right){
            int mid=left+((right-left)>>1);
            if(enough(mid,m,n,k)){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    private boolean enough(int val, int m,int n,int k){
        int cnt=0;
        for(int i=1;i<=m;i++){
            cnt+=Math.min(val/i,n);
        }
        return cnt>=k;
    }
}