class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int ans=wordsDict.length;
        int p1=-1,p2=-1;
        for(int i=0;i<wordsDict.length;i++){
            if(wordsDict[i].equals(word1)){
                p1=i;
                if(p2!=-1){
                    ans=Math.min(ans,p1-p2);
                }
            }else if(wordsDict[i].equals(word2)){
                p2=i;
                if(p1!=-1){
                    ans=Math.min(ans,p2-p1);
                }
            }
        }
        return ans;
        
    }
}