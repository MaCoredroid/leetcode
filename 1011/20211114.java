class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left=0;
        int right=0;
        for(int w:weights){
            left=Math.max(left,w);
            right+=w;
        }
        while(left<=right){
            int mid=left+((right-left)>>1);
            int cnt=1,w=0;
            for(int i=0;i<weights.length;i++){
                if(w+weights[i]>mid){
                    w=weights[i];
                    cnt++;
                }else{
                    w+=weights[i];
                }
            }
            if(cnt<=days){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}