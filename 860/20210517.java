class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] cnt=new int[2];
        for(int bill:bills){
            if(bill==5){
                cnt[0]++;
            }else if(bill==10){
                cnt[1]++;
                if(cnt[0]==0){
                    return false;
                }
                cnt[0]--;
            }else if(bill==20){
                if(cnt[0]>=3||(cnt[1]>=1&&cnt[0]>=1)){
                    if(cnt[1]>=1){
                        cnt[1]--;
                        cnt[0]--;
                    }else{
                        cnt[0]-=3;
                    }
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}