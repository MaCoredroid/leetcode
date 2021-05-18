class Solution {
    public int sumNums(int n) {
        int ans=0;
        int A=n+1;
        for(;n>0;n>>=1){
            if((n&1)!=0){
                ans+=A;
            }
            A<<=1;
        }

        return ans>>1;
    }
}