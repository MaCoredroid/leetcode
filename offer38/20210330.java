class Solution {
    public String[] permutation(String s) {
        List<String> ans=new ArrayList<>();
        char[] ch=s.toCharArray();
        Arrays.sort(ch);
        backTrack(ans,ch,new StringBuilder());
        return ans.toArray(new String[ans.size()]);
    }

    private void backTrack(List<String> ans, char[] ch,StringBuilder sb){
        if(sb.length()==ch.length){
            ans.add(sb.toString());
            return;
        }
        for(int i=0;i<ch.length;i++){
            if(ch[i]!='@'){
                char temp=ch[i];
                sb.append(ch[i]);
                ch[i]='@';
                backTrack(ans,ch,sb);
                sb.deleteCharAt(sb.length()-1);
                ch[i]=temp;
            }
            while(i+1<ch.length&&ch[i+1]==ch[i]){
                i++;
            }
        }
    }

    
}