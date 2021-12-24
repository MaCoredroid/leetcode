class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<Node>[] res=new ArrayList[26];
        for(int i=0;i<26;i++){
            res[i]=new ArrayList<>();
        }
        for(String word:words){
            res[word.charAt(0)-'a'].add(new Node(word,0));
        }
        int count=0;
        for(char c:s.toCharArray()){
            List<Node> old=res[c-'a'];
            res[c-'a']=new ArrayList<>();
            for(Node n:old){
                n.index++;
                if(n.index==n.word.length()){
                    count++;
                }else{
                    res[n.word.charAt(n.index)-'a'].add(n);
                }
            }
            
            
        }
        return count;
    }
}

class Node{
    String word;
    int index;
    public Node(String word,int index){
        this.word=word;
        this.index=index;
    }
}