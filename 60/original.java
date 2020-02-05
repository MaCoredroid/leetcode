class Solution {
    public String getPermutation(int n, int k) {
        LinkedList<Integer> nums=new LinkedList<>();
        for(int i=1;i<=n;i++)
        {
            nums.add(i);
        }
        k--;
        n--;
        StringBuilder sb=new StringBuilder();
        while(n>0)
        {
            int product=1;
            for(int i=1;i<=n;i++)
            {
                product*=i;
            }
            int res=k/product;
            k=k%product;
            int addition= nums.get(res);
            sb.append(addition);
            nums.remove(res);
            n--;
        }
        sb.append(nums.get(0));
        return sb.toString();
    }
}