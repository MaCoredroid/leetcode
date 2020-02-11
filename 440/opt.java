class Solution {
    public int findKthNumber(int n, int k) {
        long curr=1;
        long p=1;
        while(p<k)
        {
            long count=getCount(n,curr,curr+1);
            if(p+count>k)
            {
                curr*=10;
                p++;
            }
            else
            {
                curr++;
                p+=count;

            }
        }
        return (int)curr;
    }
    private long getCount(long n, long current,long prefix)
    {
        long count=0;
        while(current<=n)
        {
            count+=Math.min(prefix,n+1)-current;
            current*=10;
            prefix*=10;
        }
        return count;
    }
}