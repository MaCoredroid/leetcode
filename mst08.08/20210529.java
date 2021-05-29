class Solution {
    List<String> ans=new ArrayList<>();
    public String[] permutation(String S) {
        char[] ch=S.toCharArray();
        Arrays.sort(ch);
        backTrack(ch,0,new char[ch.length]);
        String[] res=new String[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i]=ans.get(i);
        }
        return res;
    }
    private void backTrack(char[] ch,int start,char[] ret){
        if(start==ch.length){
            ans.add(new String(ret));
            return;
        }
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='@'){
                continue;
            }
            ret[start]=(char)ch[i];
            char temp=ch[i];
            ch[i]='@';
            backTrack(ch,start+1,ret);
            ch[i]=temp;
            while(i+1<ch.length&&ch[i]==ch[i+1]){
                i++;
            }
        }
    }
}