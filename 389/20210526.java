class Solution {
    public char findTheDifference(String s, String t) {
        int[] cnt=new int[256];
        for(int i=0;i<s.length();i++){
            cnt[s.charAt(i)]++;
        }
        for(int i=0;i<t.length();i++){
            cnt[t.charAt(i)]--;
            if(cnt[t.charAt(i)]<0){
                return t.charAt(i);
            }
        }
        return ' ';
    }
}