class Solution {
    public int cuttingRope(int n) {
        if(n<=3)
        {
            return n-1;
        }
        int b=n%3;
        long ans=1;
        long product=3;
        for(int i=n/3-1;i>0;i/=2)
        {
            if(i%2==1)
            {
                ans=(ans*product)%1000000007;
            }
            product=(product*product)%1000000007;
        }
        if(b==0)
        {
            return (int)(ans*3%1000000007);
        }
        if(b==1)
        {
            return (int)(ans*4%1000000007);
        }
        return (int)(ans*6%1000000007);
    }
}