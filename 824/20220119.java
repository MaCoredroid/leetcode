class Solution {
    public String toGoatLatin(String sentence) {
        String[] words=sentence.split("\\s+");
        StringBuilder sb=new StringBuilder();
        int p=1;
        for(String w:words){
            if(beginWithVowel(w)){
                sb.append(w);
            }else{
                sb.append(w.substring(1)).append(w.charAt(0));
            }
            sb.append("ma");
            for(int i=0;i<p;i++){
                sb.append('a');
            }
            sb.append(" ");
            p++;
        }
        return sb.substring(0,sb.length()-1);
    }
    
    public boolean beginWithVowel(String w){
        w=w.toUpperCase();
        return w.charAt(0)=='A'||w.charAt(0)=='E'||w.charAt(0)=='I'||w.charAt(0)=='O'||w.charAt(0)=='U';
    }
}