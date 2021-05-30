class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] cnt=new int[100];
        int ret=0;
        for(int i=0;i<dominoes.length;i++){
            int index=dominoes[i][0]<dominoes[i][1]?dominoes[i][0]*10+dominoes[i][1]:dominoes[i][1]*10+dominoes[i][0];
            ret+=cnt[index];
            cnt[index]++;
        }
        return ret;
    }
}