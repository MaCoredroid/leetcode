class Solution {
    public int arrangeCoins(int n) {
        int left=0;
        int right=(int)Math.sqrt((long)2*n)+1;
        while(left<=right){
            int mid=left+((right-left)>>1);
            if((long)(mid+1)*(long)mid/2>n){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left-1;
    }
}