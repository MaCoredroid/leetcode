class Solution {
    public int xorOperation(int n, int start) {
        int s=start>>1,e=n&start&1;
        int ret=helper(s-1)^helper(s+n-1);
        return ret<<1|e;
    }

    private int helper(int x){
        if(x%4==0){
            return x;
        }else if(x%4==1){
            return 1;
        }else if(x%4==2){
            return x+1;
        }
        return 0;
    }
}