class Solution {
    class TrieNode{
        char c;
        TrieNode[] next;
        boolean isEnd;
        public TrieNode(char res){
            this.c=res;
            this.next=new TrieNode[26];
            this.isEnd=false;
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode dummy=new TrieNode(' ');
        for(String s:dictionary){
            TrieNode pointer=dummy;
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                if(pointer.next[c-'a']!=null){
                    pointer=pointer.next[c-'a'];
                }else{
                    TrieNode newNode=new TrieNode(c);
                    pointer.next[c-'a']=newNode;
                    pointer=newNode;
                }
            }
            pointer.isEnd=true;
        }
        StringBuilder sb= new StringBuilder();
        String[] sen = sentence.split(" ");
        for(int i=0;i<sen.length;i++){
            String origin=sen[i];
            String next=shorten(origin,dummy);
            sb.append(next).append(' ');
        }
        if(sb.length()>0){
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private String shorten(String origin,TrieNode dummy){
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<origin.length();i++){
            char c=origin.charAt(i);
            if(c==' '){
                continue;
            }
            TrieNode next=dummy.next[c-'a'];
            sb.append(c);
            if(next==null){
                return origin;
            }
            if(next.isEnd){
                break;
            }else{
                dummy=next;
            }
        }
        return sb.toString();
    }
}