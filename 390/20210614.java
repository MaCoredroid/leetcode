class Solution {
    public int lastRemaining(int n) {
        int left=1,step=1;
        boolean L2R=true;
        while(n>1){
            if(L2R||n%2==1){
                left+=step;
            }
            n/=2;
            step*=2;
            L2R=!L2R;
        }
        return left;
    }
}