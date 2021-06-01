class Solution {
    public int maxProduct(String[] words) {
        int ans=0;
        int[] masks=new int[words.length];
        int[] lens=new int[words.length];
        for(int i=0;i<words.length;i++){
            lens[i]=words[i].length();
            for(int j=0;j<lens[i];j++){
                masks[i]|=1<<(words[i].charAt(j)-'a');
            }
        }
        for(int i=0;i<masks.length;i++){
            for(int j=i+1;j<masks.length;j++){
                if((masks[i]&masks[j])==0){
                    ans=Math.max(ans,lens[i]*lens[j]);
                }
            }
        }
        return ans;
    }
}