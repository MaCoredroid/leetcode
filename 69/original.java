class Solution {
    public int mySqrt(int x) {
        if(x<1)
        {
            return 0;
        }
        if(x==1)
        {
            return 1;
        }
       
        long left=1;
        long right=x/2;
        while(left<=right)
        {
            long middle=(left+right)/2;
            if(middle*middle==x)
            {
                return (int)middle;
            }
            if(middle*middle>x)
            {
                right=middle-1;
            }
            else
            {
                left=middle+1;
            }
        }
        return (int)(left<right?left:right);
    }
}