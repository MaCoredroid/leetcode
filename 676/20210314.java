class MagicDictionary {
    class TreeNode{
        boolean isEnd;
        TreeNode[] next;
        public TreeNode(){
            isEnd=false;
            next=new TreeNode[26];
        }
    }
    TreeNode root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root=new TreeNode();
    }
    
    public void buildDict(String[] dictionary) {
        for(int i=0;i<dictionary.length;i++){
            String s=dictionary[i];
            TreeNode pointer=root;
            for(int j=0;j<s.length();j++){
                if(pointer.next[s.charAt(j)-'a']==null){
                    pointer.next[s.charAt(j)-'a']=new TreeNode();
                }
                pointer=pointer.next[s.charAt(j)-'a'];
            }
            pointer.isEnd=true;
        }
    }
    
    public boolean search(String searchWord) {
        TreeNode pointer=root;
        for(int i=0;i<searchWord.length();i++){
            for(int j=0;j<26;j++){
                if(pointer.next[j]!=null&&j!=searchWord.charAt(i)-'a'){  
                    if(noPermutationSearch(searchWord,i+1,pointer.next[j])){
                        return true;
                    }
                }
            }
            if(pointer.next[searchWord.charAt(i)-'a']!=null){
                pointer=pointer.next[searchWord.charAt(i)-'a'];
            }else{
                return false;
            }

             
        }
        return false;
    }

    private boolean noPermutationSearch(String searchWord,int pos,TreeNode start){
        TreeNode pointer=start;
        for(int i=pos;i<searchWord.length();i++){
            if(pointer.next[searchWord.charAt(i)-'a']!=null){
                pointer=pointer.next[searchWord.charAt(i)-'a'];
            }else{
                return false;
            }
        }
        return pointer.isEnd;
    }

   
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */