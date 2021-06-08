class Solution {
    public String smallestSubsequence(String s) {
        boolean[] vis=new boolean[26];
        char[] ch=s.toCharArray();
        int[] num=new int[26];
        for(int i=0;i<ch.length;i++){
            num[ch[i]-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ch.length;i++){
            if(!vis[ch[i]-'a']){
                while(sb.length()>0&&sb.charAt(sb.length()-1)>ch[i]){
                    if(num[sb.charAt(sb.length()-1)-'a']>0){
                        vis[sb.charAt(sb.length()-1)-'a']=false;
                        sb.deleteCharAt(sb.length()-1);
                    }else{
                        break;
                    }
                }
                vis[ch[i]-'a']=true;
                sb.append(ch[i]);
            }
            num[ch[i]-'a']--;
        }
        return sb.toString();
    }
}