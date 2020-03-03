class Solution {
    public int fib(int n) {
        int a=0;
        int b=1;
        int temp=-1;
        for(int i=0;i<n;i++)
        {
            temp=(a+b)%1000000007;
            a=b;
            b=temp;
        }
        return a;
    }
}