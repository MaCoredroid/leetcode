class Solution {
    public String addBoldTag(String s, String[] words) {
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<s.length()){
            int end=findEnd(s,i,words);
            if(i==end){
                sb.append(s.charAt(i++));
            }else{
                sb.append("<b>").append(s.substring(i,end)).append("</b>");
                i=end;
            }
        }
        return sb.toString();
    }
    
    public int findEnd(String s, int index, String[] words){
        int end=index;
        for(int i=index;i<=end;i++){
            for(String word:words){
                if(s.startsWith(word,i)){
                    end=Math.max(end,i+word.length());
                }
            }
        }
        return end;
    }
}