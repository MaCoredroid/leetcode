class Solution {
    public int minMoves(int target, int maxDoubles) {
        int ans=0;
        
        while(maxDoubles>0&&target>2){
            if(target%2==1){
                ans++;
                target--;
            }
            target/=2;
            ans++;
            maxDoubles--;
        }
        return ans+target-1;
    }
}