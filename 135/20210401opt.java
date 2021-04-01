class Solution {
    public int candy(int[] ratings) {
        int inc=1;
        int des=0;
        int ret=1;
        int pre=1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>=ratings[i-1]){
                des=0;
                pre=(ratings[i]==ratings[i-1]?1:pre+1);
                ret+=pre;
                inc=pre;
            }else{
                des++;
                if(des==inc){
                    des++;
                }
                ret+=des;
                pre=1;
            }
        }
        return ret;
    }
}