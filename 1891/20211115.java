class Solution {
    public int maxLength(int[] ribbons, int k) {
        int r=getMax(ribbons);
        int l=1;
        while(l<=r){
            int mid=r+((l-r)>>1);
            if(aboveK(ribbons,mid,k)){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return l-1;
    }
    
    public int getMax(int[] ribbons){
        int maxV=ribbons[0];
        for(int r:ribbons){
            maxV=Math.max(maxV,r);
        }
        return maxV;
    }
    
    public boolean aboveK(int[] ribbons,int mid,int k){
        int cnt=0;
        for(int r:ribbons){
            cnt+=r/mid;
        }
        return cnt>=k;
    }
}