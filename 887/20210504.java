class Solution {
    Map<Integer,Integer> res=new HashMap<>();
    public int superEggDrop(int k, int n) {
        return dp(k,n);
    }

    public int dp(int k,int n){
        if(!res.containsKey(100*n+k)){
            int ans=0;
            if(n==0||n==1){
                ans=n;
            }else if(k==1){
                ans=n;
            }else{
                int left=1;
                int right=n;
                boolean flag=false;
                while(left<=right){
                    int middle=(left+right)/2;
                    int val1=dp(k-1,middle-1);
                    int val2=dp(k,n-middle);
                    if(val1>val2){
                        right=middle-1;
                    }else if(val1<val2){
                        left=middle+1;
                    }else{
                        left=middle; 
                        flag=true;
                        break;
                    }
                }
                if(flag){
                    ans=1+Math.max(dp(k,n-left),dp(k-1,left-1));
                }else{
                    ans=1+Math.min(Math.max(dp(k,n-left),dp(k-1,left-1)),Math.max(dp(k,n-left+1),dp(k-1,left-2)));
                }
            }
            res.put(100*n+k,ans);
        }

        return res.get(100*n+k);
    }
}