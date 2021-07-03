class Solution {
    public int minNumberOperations(int[] target) {
        int cnt=0;
        int pre=0;
        for(int i=0;i<target.length;i++){
            if(target[i]-pre>0){
                cnt+=target[i]-pre;
            }
            pre=target[i];
        }
        return cnt;
    }
}