class Solution {
    public int countDigitOne(int n) {
        int count=0;
        for(long i=1;i<=n;i*=10){
            long divder=i*10;
            count+=(n/divder)*i+Math.min(Math.max(0,n%divder-i+1),i);
        }
        return count;
    }
}