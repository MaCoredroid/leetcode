class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> ans=new ArrayList<>();
        ans.add(1);
        while(ans.size()<n){
            List<Integer> tmp=new ArrayList<>();
            for(int i:ans){
                if(2*i-1<=n){
                    tmp.add(2*i-1);
                }
            }
            for(int i:ans){
                if(2*i<=n){
                    tmp.add(2*i);
                }
            }
            ans=tmp;
        }
        int[] ret=new int[n];
        for(int i=0;i<n;i++){
            ret[i]=ans.get(i);
        }
        return ret;
    }
}