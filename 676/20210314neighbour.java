class MagicDictionary {
    Set<String> words;
    Map<String, Integer> count;
    public MagicDictionary() {
        words = new HashSet<>();
        count = new HashMap<>();
    }
    
    public void buildDict(String[] dictionary) {
        for(String word:dictionary){
            words.add(word);
            for(String magic:generateNeighbours(word)){
                count.put(magic,count.getOrDefault(magic,0)+1);
            }
        }
    }
    
    private List<String> generateNeighbours(String word){
        List<String> ans=new ArrayList<>();
        char[] ca=word.toCharArray();
        for(int i=0;i<ca.length;i++){
            char temp=ca[i];
            ca[i]='*';
            ans.add(new String(ca));
            ca[i]=temp;
        }
        return ans;

    }
    public boolean search(String searchWord) {
        for(String magic:generateNeighbours(searchWord)){
            int c=count.getOrDefault(magic,0);
            if(c>=2||(c==1&&!words.contains(searchWord))){
                return true;
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