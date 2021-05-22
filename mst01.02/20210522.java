class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }
        int[] cnt=new int[128];
        for(int i=0;i<s1.length();i++){
            cnt[s1.charAt(i)]++;
        }
        for(int i=0;i<s1.length();i++){
            cnt[s2.charAt(i)]--;
            if(cnt[s2.charAt(i)]<0){
                return false;
            }
        }
        return true;
    }
}