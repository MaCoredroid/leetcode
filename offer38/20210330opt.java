class Solution {
    public String[] permutation(String s) {
        List<String> ans=new ArrayList<>();
        char[] ch=s.toCharArray();
        backTrack(ans,ch,0);
        return ans.toArray(new String[ans.size()]);
    }

    private void backTrack(List<String> ans, char[] ch,int pointer){
        if(pointer==ch.length){
            ans.add(new String(ch));
            return;
        }
        for(int i=pointer;i<ch.length;i++){
            if(canswap(ch,pointer,i)){
                swap(ch,i,pointer);
                backTrack(ans,ch,pointer+1);
                swap(ch,pointer,i);
            }
        }
    }
    private void swap(char[] ch,int i,int j){
        char temp=ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
    }
    private boolean canswap(char[] ch,int left,int right){
        for(int i=left;i<right;i++){
            if(ch[i]==ch[right]){
                return false;
            }
        }
        return true;
    }

    
}