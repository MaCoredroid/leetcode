class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> ans=new ArrayList<>();
        int p1=0,p2=0;
        int lastProduct=-1,lastFreq=-1;
        while(p1<encoded1.length){
            int amount=Math.min(encoded1[p1][1],encoded2[p2][1]);
            int product=encoded1[p1][0]*encoded2[p2][0];
            if(product==lastProduct){
                ans.get(ans.size()-1).set(1,lastFreq+amount);
            }else{
                ans.add(Arrays.asList(product,amount));
            }
            encoded1[p1][1]-=amount;
            encoded2[p2][1]-=amount;
            if(encoded1[p1][1]==0){
                p1++;
            }
            if(encoded2[p2][1]==0){
                p2++;
            }
            lastProduct=product;
            lastFreq=amount;
            
        }
        return ans;
    }
    
    
}