class Solution {
    public String getPermutation(int n, int k) {
        int[] nums=new int[n];
        boolean[] visited=new boolean[n];
        for(int i=1;i<=n;i++)
        {
            nums[i-1]=i;
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
            int count=res;
            int i=0;
            for(;i<nums.length;i++)
            {
                if(count==0)
                {
                    if(!visited[i])
                    {
                        sb.append(nums[i]);
                        break;
                    }
                }
                if(!visited[i])
                {
                    count--;
                }

            }
            visited[i]=true;
            n--;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(!visited[i])
            {
                sb.append(nums[i]);
                break;
            }
        }
        return sb.toString();
    }
}