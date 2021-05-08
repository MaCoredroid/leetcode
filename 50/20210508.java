class Solution {
    public double myPow(double x, int n) {
        long N=n;
        return N>0?helper(x,N):1.0/helper(x,-N);

    }

    private double helper(double x, long n){
        double ans=1.0;
        double x_contribute=x;
        while(n>0){
            if(n%2==1){
                ans*=x_contribute;
            }
            x_contribute*=x_contribute;
            n/=2;
        }
        return ans;
    }
}