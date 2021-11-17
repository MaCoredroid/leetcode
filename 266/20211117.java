class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] cnt=new int[128];
        for(char c:s.toCharArray()){
            cnt[c]++;
        }
        int ans=0;
        for(int a:cnt){
            if(a%2==1){
                ans++;
            }
        }
        return ans<=1;
    }
}