class Solution {

    private int getCount(int perfix, int n){
        int count=0;
        for(int a=perfix,b=perfix+1;a<=n;a*=10,b*=10){
            count+=Math.min(n+1,b)-a;
        }
        return count;
    }
    public int findKthNumber(int n, int k) {
        int i=1;
        int count=1;
        while(count<k){
            int cnt=getCount(i,n);
            if(count+cnt>k){
                i=i*10;
                count++;
            }else{
                i++;
                count+=cnt;
            }
        }
        return i;
    }
}