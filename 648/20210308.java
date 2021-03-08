class Solution {
    class TrieNode{
        char c;
        HashMap<Character,TrieNode> next;
        boolean isEnd;
        public TrieNode(char res){
            this.c=res;
            this.next=new HashMap<>();
            this.isEnd=false;
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode dummy=new TrieNode(' ');
        for(String s:dictionary){
            TrieNode pointer=dummy;
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                if(pointer.next.containsKey(c)){
                    pointer=pointer.next.get(c);
                }else{
                    TrieNode newNode=new TrieNode(c);
                    pointer.next.put(c,newNode);
                    pointer=newNode;
                }
            }
            pointer.isEnd=true;
        }
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<sentence.length();i++){
            int left=i;
            while(i<sentence.length()&&sentence.charAt(i)!=' '){
                i++;
            }
            String origin=sentence.substring(left,i);
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
            TrieNode next=dummy.next.get(c);
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