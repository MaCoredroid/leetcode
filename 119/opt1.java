class Solution {
    public List<Integer> getRow(int rowIndex) {
        long pre=1;
        List<Integer> ret=new ArrayList();
        ret.add(1);
        for(int k=1;k<=rowIndex;k++)
        {
            long curr=pre*(rowIndex-k+1)/k;
            ret.add((int)curr);
            pre=curr;
        }
        return ret;
    }
}