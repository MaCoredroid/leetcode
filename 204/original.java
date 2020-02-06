class Solution {
    public int countPrimes(int n) {
        boolean[] map=new boolean[n+1];
        int count=0;
        int i=2;
        int temp=(int)Math.sqrt(n);
        for(;i<=temp;i++)
        {
            if(!map[i])
            {
                count++;                
                for(int j=i;j*i<n;j++)
                {
                    map[j*i]=true;
                }
                
            }
        }
        for(;i<n;i++)
        {
            if(!map[i])
            {
                count++;  
            }

        }
        return count;
    }
}