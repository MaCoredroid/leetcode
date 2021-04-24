class Solution {
    public int findKthNumber(int n, int k) {
        long count=1;
        long curr=1;
        while(count<k){
            long cnt=count(n,curr);
            if(count+cnt>k){
                curr*=10;
                count++;
            }else{
                curr++;
                count+=cnt;
            }
        }
        return (int)curr;
    }

    

    private long count(long n, long prefix){
        long ans=0;
        for(long a=prefix,b=prefix+1;a<=n;a*=10,b*=10){
            ans+=Math.min(b,n+1)-a;
        }
        return ans;
    }
}