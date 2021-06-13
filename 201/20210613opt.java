class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int shift=0;
        while(m<n){
            n=n&(n-1);
        }
        return n;
    }
}