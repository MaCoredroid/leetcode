class Solution {
    Node dummy;
    String ans="";
    public String longestWord(String[] words) {
        dummy=new Node();
        for(String res:words){
            char[] ch=res.toCharArray();
            Node curr=dummy;
            for(int i=0;i<ch.length;i++){
                if(curr.next[ch[i]-'a']==null){
                    curr.next[ch[i]-'a']=new Node();
                }
                curr=curr.next[ch[i]-'a'];
            }
            curr.isEnd=true;
        }
        dummy.isEnd=true;
        getAns(dummy,new StringBuilder());
        return ans;
    }

    private void getAns(Node curr,StringBuilder sb){
        if(!curr.isEnd){
            return;
        }
        if(sb.length()>ans.length()){
            ans=new String(sb);
        }
        for(int i=0;i<26;i++){
            if(curr.next[i]!=null){
                sb.append((char)('a'+i));
                getAns(curr.next[i],sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    
}

class Node{
    Node[] next;
    boolean isEnd;
    public Node(){
        next=new Node[26];
        isEnd=false;
    }
}