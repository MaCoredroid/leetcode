class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int[] cnt=new int[26];
        for(int i=0;i<s1.length();i++){
            cnt[s1.charAt(i)-'a']--;
        }
        int left=0;
        for(int right=0;right<s2.length();right++){
            int x=s2.charAt(right)-'a';
            cnt[x]++;
            while(cnt[x]>0){
                cnt[s2.charAt(left)-'a']--;
                left++;
            }
            if(right-left+1==s1.length()){
                return true;
            }
        }
        return false;
    }
}