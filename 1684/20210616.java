class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] cnt=new int[26];
        char[] ch=allowed.toCharArray();
        for(int i=0;i<ch.length;i++){
            cnt[ch[i]-'a']++;
        }
        int ans=0;
        for(String word:words){
            boolean flag=true;
            for(char c:word.toCharArray()){
                if(cnt[c-'a']==0){
                    flag=false;
                    break;
                }
            }
            if(flag){
                ans++;
            }
        }
        return ans;
    }
}