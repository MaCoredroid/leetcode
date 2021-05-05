class Solution {
    public int[][] findContinuousSequence(int target) {
        int j=2;
        int ans=1;
        List<int[]> ret=new ArrayList<>();
        for(int i=1;i<=target/2;i++){
            while(ans+j<=target){
                ans+=j;
                j++;
            }
            if(ans==target){
                int[] row=new int[j-i];
                for(int p=i;p<j;p++){
                    row[p-i]=p;
                }
                ret.add(row);
            }
            ans-=i;
        }
        return ret.toArray(new int[ret.size()][]);
    }
}