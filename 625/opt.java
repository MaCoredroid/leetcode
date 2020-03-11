class Solution {
    public int smallestFactorization(int a) {
        if(a<2)
        {
            return a;
        }
        long res=0;
        long base=1;
        for(int i=9;i>=2;i--)
        {
            while(a%i==0)
            {
                a/=i;
                res+=i*base;
                base*=10;
            }
        }
        return a < 2 && res <= Integer.MAX_VALUE ?(int)res:0;
    }
}