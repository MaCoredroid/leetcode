class Solution {
    public String addBoldTag(String s, String[] words) {
        char[] ch=s.toCharArray();
        boolean[] mask=new boolean[ch.length];
        for(int i=0;i<ch.length;i++){
            for(String word:words){
                int k=0;
                for(;k<word.length();k++){
                    if(k+i>=ch.length||ch[k+i]!=word.charAt(k)){
                        break;
                    }
                }
                if(k==word.length()){
                    for(int j=i;j<i+k;j++){
                        mask[j]=true;
                    }
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<mask.length;i++){
            if(mask[i]&&(i==0||!mask[i-1])){
                sb.append("<b>");
            }
            sb.append(ch[i]);
            if(mask[i]&&(i+1==ch.length||!mask[i+1])){
                sb.append("</b>");
            }
        }
        return sb.toString();
    }
}