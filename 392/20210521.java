class Solution {
    public boolean isSubsequence(String s, String t) {
        int pointer1=0,pointer2=0;
        while(pointer2<t.length()&&pointer1<s.length()){
            while(pointer2<t.length()&&t.charAt(pointer2)!=s.charAt(pointer1)){
                pointer2++;
            }
            if(pointer2>=t.length()){
                return false;
            }
            pointer1++;
            pointer2++;
        }
        return pointer1==s.length();
    }
}