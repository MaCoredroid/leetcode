class Solution {
    public int game(int[] guess, int[] answer) {
        int cnt=0;
        for(int i=0;i<guess.length;i++){
            if(answer[i]==guess[i]){
                cnt++;
            }
        }
        return cnt;
    }
}