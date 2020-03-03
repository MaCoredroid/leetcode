class Solution {
    public int numWays(int n) {
        int a=1;
        int b=2;
        int sum=0;
        for(int i=1;i<n;i++)
        {
            sum=(a+b)%1000000007;
            a=b;
            b=sum;
        }
        return a;
    }
}