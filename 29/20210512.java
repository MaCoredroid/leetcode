class Solution {
    public int divide(int dividend, int divisor) {
        long x=dividend,y=divisor;
        boolean isNeg=false;
        if((x>0&&y<0)||(x<0&&y>0)){
            isNeg=true;
        }
        if(x<0){
            x=-x;
        }
        if(y<0){
            y=-y;
        }
        long left=0,right=x;
        while(left<=right){
            long middle=left+((right-left)>>1);
            if(check(x,y,middle)){
                right=middle-1;
            }else{
                left=middle+1;
            }
        }
        long ans=isNeg?-(left-1):left-1;
        if(ans>Integer.MAX_VALUE||ans<Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int)ans;
    }

    private boolean check(long dividend,long divisor,long target){
        long ans=0;
        long base=divisor;
        while(target>0){
            if((target&1)==1){
                ans+=base;
            }
            base+=base;
            target=(target>>1);
        }
        return ans>dividend;
    }
}