class Solution {
    public List<Integer> getRow(int rowIndex) {
        int pre=1;
        List<Integer> ret=new ArrayList();
        ret.add(1);
        for(int i=1;i<=rowIndex;i++)
        {
            for(int j=1;j<i;j++)
            {
                int temp=ret.get(j);
                ret.set(j,pre+temp);
                pre=temp;
            }
            ret.add(1);
        }
        return ret;
    }
}