class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        String ans="";
        Set<String> set=new HashSet<>();
        for(String word:words){
            set.add(word);
        }
        for(String word:words){
            char[] ch=word.toCharArray();
            boolean[] dp=new boolean[ch.length];
            if(ch.length==0){
                continue;
            }
            for(int i=0;i<ch.length;i++){
                if(i<ch.length-1&&set.contains(new  String(ch,0,i+1))){
                    dp[i]=true;
                }
                for(int j=0;j<i;j++){
                    if(dp[j]&&set.contains(new String(ch,j+1,i-j))){
                        dp[i]=true;
                    }
                }
            }
            if(dp[ch.length-1]&&word.length()>ans.length()){
                ans=word;
            }
        }
        return ans;
    }
}