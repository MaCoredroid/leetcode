class Solution {
    public int[] countBits(int num) {
        int[] bits=new int[num+1];
        int HighBit=1;
        for(int i=1;i<=num;i++){
            if((i&(i-1))==0){
                HighBit=i;
            }
            bits[i]=bits[i-HighBit]+1;
        }
        return bits;
    }
}