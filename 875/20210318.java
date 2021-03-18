class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right=1_000_000_000;
        int left=1;
        while(left<right){
            int middle=(left+right)/2;
            int time=0;
            for(int i=0;i<piles.length;i++){
                time+=(piles[i]-1)/middle+1;
            }
            if(time>h){
                left=middle+1;
            }else{
                right=middle;
            }
        }
        return left;
    }
}