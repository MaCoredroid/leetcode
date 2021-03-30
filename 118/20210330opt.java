class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        curr.add(1);
        for(int i=0;i<numRows;i++){
            
            for(int j=i;j>0;j--){
                if(j==i){
                    curr.add(1);
                }else{
                    curr.set(j,curr.get(j-1)+curr.get(j));
                }
            }
            ans.add(new ArrayList<>(curr));
        }
        return ans;
    }
}