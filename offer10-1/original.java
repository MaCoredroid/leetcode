class Solution {
    public int fib(int n) {
        List<Integer> ans=new ArrayList<>();
        ans.add(0);
        ans.add(1);
        for(int i=2;i<=n;i++)
        {
            ans.add((ans.get(i-2)+ans.get(i-1)) % 1000000007);
        }
        return ans.get(n);
    }
}