class Solution {
    public int longestPalindrome(String s){
        boolean single=false;
        int ans=0;
        int[] counts=new int[128];
        for(int i=0;i<s.length();i++){
            counts[s.charAt(i)]++;
        }
        for(int count:counts){
            ans+=count/2;
            if(count%2==1){
                single=true;
            }
        }
        return single?2*ans+1:2*ans;
    }
}