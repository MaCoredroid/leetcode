class MagicDictionary {
    String[] res;
    class TreeNode{
        
    }
    
    public void buildDict(String[] dictionary) {
        res=dictionary;
    }
    
    public boolean search(String searchWord) {
        for(String word:res){
            if(word.length()==searchWord.length()){
                int cnt=0;
                for(int p=0,q=searchWord.length()-1;p<=q && cnt<2;p++,q--){
                    if(word.charAt(p)!=searchWord.charAt(p)){
                        cnt++;
                    }
                    if(p<q&&word.charAt(q)!=searchWord.charAt(q)){
                        cnt++;
                    }
                }
                if(cnt==1){
                    return true;
                }
            }
        }
        return false;    
    }

    
   
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */