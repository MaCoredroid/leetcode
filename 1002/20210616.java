class Solution {
    public List<String> commonChars(String[] words) {
        int[] cnt=new int[26];
        if(words.length==0){
            return new ArrayList<>();
        }
        for(char c:words[0].toCharArray()){
            cnt[c-'a']++;
        }
        for(int i=1;i<words.length;i++){
            int[] cnt1=new int[26];
            for(char c:words[i].toCharArray()){
                cnt1[c-'a']++;
            }
            for(int j=0;j<26;j++){
                cnt[j]=Math.min(cnt[j],cnt1[j]);
            }
        }
        List<String> ans=new ArrayList<>();
        for(int i=0;i<26;i++){
            for(int j=0;j<cnt[i];j++){
                ans.add(""+(char)(i+'a'));
            }
        }
        return ans;
    }
}