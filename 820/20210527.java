class Solution {
    public int minimumLengthEncoding(String[] words) {
        TrieNode root=new TrieNode();
        Map<TrieNode,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            String word=words[i];
            TrieNode cur=root;
            for(int j=word.length()-1;j>=0;j--){
                cur=cur.getChildren(word.charAt(j)-'a');
            }
            map.put(cur,i);
            
        }
        int cnt=0;
        for(TrieNode node:map.keySet()){
            if(node.count==0){
                cnt+=words[map.get(node)].length()+1;
            }
        }
        return cnt;
        
    }
}

class TrieNode{
    TrieNode[] children=new TrieNode[26];
    int count=0;

    public TrieNode(){

    }

    public TrieNode getChildren(int b){
        if(children[b]==null){
            children[b]=new TrieNode();
            count++;
        }
        return children[b];
    }
}