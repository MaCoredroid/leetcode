class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] index=new int[26];
        for(int i=0;i<order.length();i++){
            index[order.charAt(i)-'a']=i;
        }
        for(int i=0;i<words.length-1;i++){
            String pre=words[i];
            String next=words[i+1];
            int j=0;
            for(;j<Math.min(pre.length(),next.length());j++){
                if(index[pre.charAt(j)-'a']>index[next.charAt(j)-'a']){
                    return false;
                }else if(index[pre.charAt(j)-'a']<index[next.charAt(j)-'a']){
                    break;
                }
            }
            if(j==Math.min(pre.length(),next.length())&&pre.length()>next.length()){
                return false;
            }
        }
        return true;
    }
}