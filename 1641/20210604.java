class Solution {
    int[] res=new int[]{1,2,3,4,5};
    public int countVowelStrings(int n) {
        return helper(n,n,0);
    }

    private int helper(int n,int level,int pointer){
        if(level==0){
            return 1;
        }
        int ans=0;
        for(int i=pointer;i<res.length;i++){
            ans+=helper(n,level-1,i);
        }
        return ans;
    }
}