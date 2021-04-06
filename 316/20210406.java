class Solution {
    public String removeDuplicateLetters(String s) {
        char[] ch=s.toCharArray();
        boolean[] vis=new boolean[26];
        int[] count=new int[26];
        for(int i=0;i<ch.length;i++){
            count[ch[i]-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ch.length;i++){
            if(!vis[ch[i]-'a']){
                while(sb.length()>0&&sb.charAt(sb.length()-1)>ch[i]){
                    if(count[sb.charAt(sb.length()-1)-'a']>0){
                        vis[sb.charAt(sb.length()-1)-'a']=false;
                        sb.deleteCharAt(sb.length()-1);
                    }else{
                        break;
                    }
                }
                sb.append(ch[i]);
                vis[ch[i]-'a']=true;
            }
            count[ch[i]-'a']--;
        }
        return sb.toString();
    }
}