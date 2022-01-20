class Solution {
    public String reorganizeString(String s) {
        int[] cnt=new int[26];
        for(char c:s.toCharArray()){
            cnt[c-'a']++;
        }
        int max=0;
        char letter='a';
        for(int i=0;i<26;i++){
            if(cnt[i]>max){
                letter=(char)('a'+i);
                max=cnt[i];
            }
        }
        if(max>(s.length()+1)/2){
            return "";
        }
        int idx=0;
        char[] ret=new char[s.length()];
        while(cnt[letter-'a']>0){
            ret[idx]=letter;
            idx+=2;
            cnt[letter-'a']--;
        }
        for(int i=0;i<26;i++){
            while(cnt[i]>0){
                if(idx>=s.length()){
                    idx=1;
                }
                ret[idx]=(char)('a'+i);
                idx+=2;
                cnt[i]--;
            }
        }
        return new String(ret);
    }
}