class Solution {
    List<Integer> ans=new ArrayList<>();
    public int[] pondSizes(int[][] land) {
        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[0].length;j++){
                if(land[i][j]==0){
                    ans.add(helper(land,i,j));
                }
            }
        }
        Collections.sort(ans);
        int[] ret=new int[ans.size()];
        for(int i=0;i<ret.length;i++){
            ret[i]=ans.get(i);
        }
        return ret;

    }

    private int helper(int[][] land,int i,int j){
        if(i<0||i>=land.length||j<0||j>=land[0].length){
            return 0;
        }
        if(land[i][j]!=0){
            return 0;
        }
        land[i][j]=1;
        return 1+helper(land,i-1,j)+helper(land,i+1,j)+helper(land,i,j+1)+helper(land,i,j-1)+helper(land,i-1,j-1)+helper(land,i+1,j+1)+helper(land,i+1,j-1)+helper(land,i-1,j+1);
    }
}