class Solution {
    public int mySqrt(int x) {
        int left=0;
        int right=x;
        while(left<=right){
            int middle=(left+right)/2;
            if((long)middle*middle==x){
                return middle;
            }else if((long)middle*middle<x){
                left=middle+1;
            }else{
                right=middle-1;
            }
        }
        if((long)left*left>x){
            left--;
        }
        return left;
    }
}