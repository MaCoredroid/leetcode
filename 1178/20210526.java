class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer,Integer> freq=new HashMap<>();
        for(String word:words){
            int mask=0;
            for(int i=0;i<word.length();i++){
                mask|=1<<(word.charAt(i)-'a');
            }
            if(Integer.bitCount(mask)<=7){
                freq.put(mask,freq.getOrDefault(mask,0)+1);
            }
        }
        List<Integer> ret=new ArrayList<>();
        for(String puzzle:puzzles){
            int ans=0;
            for(int i=0;i<(1<<6);i++){
                int mask=0;
                for(int j=1;j<=7;j++){
                    if((i&(1<<j-1))!=0){
                        mask|=(1<<puzzle.charAt(j)-'a');
                    }
                }
                mask|=(1<<puzzle.charAt(0)-'a');
                ans+=freq.getOrDefault(mask,0);
            }
            ret.add(ans);
            

        }
        return ret;
    }
}