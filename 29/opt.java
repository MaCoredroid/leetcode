class Solution {
    public int divide(int dividend, int divisor) {
        boolean sign=(dividend<0)^(divisor<0);
        int result=0;
        if(dividend>0)
        {
            dividend=-dividend;
        }
        if(divisor>0)
        {
            divisor=-divisor;
        }
        while(dividend<=divisor)
        {
            int tempdivisor=divisor;
            int tempresult=-1;
            while(dividend<=(tempdivisor<<1))
            {
                if(tempdivisor<=(Integer.MIN_VALUE>>1))
                {
                    break;
                }
                tempresult=tempresult<<1;
                tempdivisor=tempdivisor<<1;
            }
            dividend-=tempdivisor;
            result+=tempresult;
        }
        if(!sign)
        {
            if(result<=Integer.MIN_VALUE)
            {
                return Integer.MAX_VALUE;
            }
            result=-result;
        }
        return result;
    }
}